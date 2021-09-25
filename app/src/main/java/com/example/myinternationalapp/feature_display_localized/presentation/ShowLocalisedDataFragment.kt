package com.example.myinternationalapp.feature_display_localized.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myinternationalapp.R
import com.example.myinternationalapp.databinding.ShowLocalisedDataFragmentBinding
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.presentation.adapter.AppLocale
import com.example.myinternationalapp.feature_display_localized.presentation.adapter.ItemClickListener
import com.example.myinternationalapp.feature_display_localized.presentation.adapter.ShowLocalisedDataAdapter
import com.example.myinternationalapp.feature_display_localized.presentation.model.Status
import com.example.myinternationalapp.feature_display_localized.presentation.model.UiModel
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
                    viewModel.loadDataFromLocale(item.title)
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
            showLocaleAdapter = ShowLocalisedDataAdapter(mutableListOf(), clickListener)
            layoutManager = LinearLayoutManager(context)
            adapter = showLocaleAdapter
        }

        lifecycleScope.launchWhenCreated {
            registerForUIUpdates()
        }
    }

    private suspend fun registerForUIUpdates() {
        viewModel.uiState.collect {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { data ->
                        binding.data = data
                    }
                }
                Status.ERROR,
                -> {
                    it.message?.let { message -> binding.errorInfo.text = message }
                }
                Status.LOADING,
                -> {
                }
            }
            updateUIVisibility(uiModel = it)
        }
    }

    private fun updateUIVisibility(uiModel: UiModel<LocalizedData>) {
        binding.apply {
            when (uiModel.status) {
                Status.SUCCESS -> {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    errorInfo.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                    errorInfo.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    errorInfo.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}