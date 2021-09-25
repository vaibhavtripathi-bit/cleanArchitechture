package com.example.myinternationalapp.feature_display_localized.presentation.binding_adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.presentation.model.ShowLocalizedUiModel

class DataBindingAdapters {

    companion object {
        @BindingAdapter("setLocalisedText")
        @JvmStatic
        fun setTextViewLocalisedText(textView: TextView, showLocalizedUiModel: ShowLocalizedUiModel?) {
            showLocalizedUiModel?.let {
                textView.text = showLocalizedUiModel.title
            }
        }
    }
}
