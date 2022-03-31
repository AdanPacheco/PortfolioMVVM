package com.portfolio.mvvm.data.model.network

import com.portfolio.mvvm.core.RetrofitHelper
import com.portfolio.mvvm.data.model.models.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val apiClient: QuoteApiClient
){

    suspend fun getQuote():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = apiClient.getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}