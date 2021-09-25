package com.example.myinternationalapp.utils

import android.content.Context

fun String.getStringResource(context: Context, stringResID: Int) {
    context.resources.getString(stringResID)
}
