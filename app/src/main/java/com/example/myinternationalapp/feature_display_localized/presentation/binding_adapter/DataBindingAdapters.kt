package com.example.myinternationalapp.feature_display_localized.presentation.binding_adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData

class DataBindingAdapters {

    companion object {
        @BindingAdapter("setLocalisedText")
        @JvmStatic
        fun setTextViewLocalisedText(textView: TextView, localizedData: LocalizedData?) {
            localizedData?.let {
                textView.text = localizedData.value
            }
        }
    }
}
