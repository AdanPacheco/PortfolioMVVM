package com.portfolio.mvvm.data.model.network

import com.portfolio.mvvm.data.model.models.QuoteModel
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}