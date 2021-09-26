package com.example.myinternationalapp.feature_display_localized.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myinternationalapp.R
import com.example.myinternationalapp.databinding.ItemShowLocaleTitleBinding

class ShowLocalisedDataAdapter(
    private var _itemList: MutableList<AppLocale>,
    private val onClickListener: ItemClickListener? = null,
) : RecyclerView.Adapter<ShowLocalisedDataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowLocalisedDataViewHolder {
        return when (viewType) {
            R.layout.item_show_locale_title -> {
                ShowLocalisedDataViewHolder.SelectLocaleViewHolder(
                    ItemShowLocaleTitleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw Exception("Unknown View Holder Type")
        }
    }

    override fun onBindViewHolder(holder: ShowLocalisedDataViewHolder, position: Int) {
        holder.itemClickListener = onClickListener
        val item = _itemList[position]
        when (holder) {
            is ShowLocalisedDataViewHolder.SelectLocaleViewHolder -> holder.bind(item as AppLocale.Title)
        }
    }

    override fun getItemCount() = _itemList.size

    override fun getItemViewType(position: Int): Int {
        return when (_itemList[position]) {
            is AppLocale.Title -> R.layout.item_show_locale_title
        }
    }
}