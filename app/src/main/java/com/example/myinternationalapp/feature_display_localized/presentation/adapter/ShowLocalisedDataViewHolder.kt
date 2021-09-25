package com.example.myinternationalapp.feature_display_localized.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.myinternationalapp.databinding.ItemShowlocaleTitleBinding

sealed class ShowLocalisedDataViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    var itemClickListener: ItemClickListener? = null

    class SelectLocaleViewHolder(
        private val binding: ItemShowlocaleTitleBinding,
    ) : ShowLocalisedDataViewHolder(binding) {
        fun bind(item: AppLocale.Title) {
            binding.apply {
                localeTitle.text = item.title
                root.setOnClickListener {
                    itemClickListener?.clickListener(it, item, adapterPosition)
                }
            }
        }
    }
}