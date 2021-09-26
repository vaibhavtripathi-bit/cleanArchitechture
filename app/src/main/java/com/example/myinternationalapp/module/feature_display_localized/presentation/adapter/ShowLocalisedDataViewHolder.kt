package com.example.myinternationalapp.module.feature_display_localized.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.myinternationalapp.databinding.ItemShowLocaleTitleBinding

sealed class ShowLocalisedDataViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    var itemClickListener: ItemClickListener? = null

    class SelectLocaleViewHolder(
        private val binding: ItemShowLocaleTitleBinding,
    ) : ShowLocalisedDataViewHolder(binding) {
        fun bind(item: AppLocale.Title) {
            binding.apply {
                localeTitle.text = item.title
                localeTitle.setOnClickListener {
                    itemClickListener?.clickListener(it, item, adapterPosition)
                }
            }
        }
    }
}
