package com.example.myinternationalapp.module.feature_display_localized.data.network.apiservices

import com.example.myinternationalapp.module.feature_display_localized.data.network.response.LocalisedDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocaleApiService {

    @GET("api_end_point")
    suspend fun getLocalizedData(
        @Query("screen") searchQuery: String,
        @Query("localization") apiKey: String
    ): LocalisedDataResponse
}
