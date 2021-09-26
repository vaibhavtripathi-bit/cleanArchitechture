package com.example.myinternationalapp.feature_display_localized.data.network.apiservices

import com.example.myinternationalapp.feature_display_localized.data.constant.Constants
import com.example.myinternationalapp.feature_display_localized.data.network.response.LocalisedDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocaleApiService {

    @GET("api_end_point")
    suspend fun getLocalizedData(
        @Query("screen") searchQuery: String,
        @Query("localization") apiKey: String
    ): LocalisedDataResponse

}