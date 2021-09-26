package com.example.myinternationalapp.module.feature_display_localized.presentation.adapter

import android.view.View

interface ItemClickListener {
    fun clickListener(itemView: View, item: AppLocale, position: Int)
}