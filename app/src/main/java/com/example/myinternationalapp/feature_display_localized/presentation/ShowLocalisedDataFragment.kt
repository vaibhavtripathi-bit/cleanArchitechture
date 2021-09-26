package com.example.myinternationalapp.feature_display_localized.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myinternationalapp.R
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.databinding.ShowLocalisedDataFragmentBinding
import com.example.myinternationalapp.feature_display_localized.presentation.ShowLocalisedDataViewModel.ViewState
import com.example.myinternationalapp.feature_display_localized.presentation.adapter.AppLocale
import com.example.myinternationalapp.feature_display_localized.presentation.adapter.ItemClickListener
import com.example.myinternationalapp.feature_display_localized.presentation.adapter.ShowLocalisedDataAdapter
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShowLocalisedDataFragment : Fragment() {
    private val viewModel by viewModel<ShowLocalisedDataViewModel>()
    private var _binding: ShowLocalisedDataFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var showLocaleAdapter: ShowLocalisedDataAdapter

    private val clickListener = object : ItemClickListener {
        override fun clickListener(itemView: View, item: AppLocale, position: Int) {
            when (item) {
                is AppLocale.Title -> {
                    activity?.let { viewModel.loadDataFromLocale(it, item.title) }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.show_localised_data_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            showLocaleAdapter = ShowLocalisedDataAdapter(
                _itemList = mutableListOf(
                    AppLocale.Title(SelectedLocale.ENGLISH.name),
                    AppLocale.Title(SelectedLocale.GERMAN.name),
                    AppLocale.Title(SelectedLocale.FRENCH.name),
                    AppLocale.Title(SelectedLocale.SPANISH.name)
                ),
                onClickListener = clickListener
            )
            adapter = showLocaleAdapter
        }

        lifecycleScope.launchWhenCreated {
            activity?.let { viewModel.initializeData(it) }
            registerForUIUpdates()
        }
    }

    private suspend fun registerForUIUpdates() {
        viewModel.viewState.collect {
            when (it) {
                is ViewState.LoadingState -> {
                }
                is ViewState.ValueAvailableState -> {
                    binding.data = it.uiModel
                }
            }
            updateUIVisibility(viewState = it)
        }
    }

    private fun updateUIVisibility(viewState: ViewState) {
        binding.apply {
            when (viewState) {
                is ViewState.LoadingState -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                is ViewState.ValueAvailableState -> {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}