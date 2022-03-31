package com.portfolio.mvvm.data.model

import com.portfolio.mvvm.data.database.dao.QuoteDao
import com.portfolio.mvvm.data.database.entities.QuoteEntity
import com.portfolio.mvvm.data.model.models.QuoteModel
import com.portfolio.mvvm.data.model.network.QuoteService
import com.portfolio.mvvm.domain.model.Quote
import com.portfolio.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {


    suspend fun getAllQuotesFromApi():List<Quote>{
        val response :List<QuoteModel> = api.getQuote()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}