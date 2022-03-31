package com.portfolio.mvvm.domain

import com.portfolio.mvvm.data.database.entities.toDatabase
import com.portfolio.mvvm.data.model.QuoteRepository
import com.portfolio.mvvm.data.model.models.QuoteModel
import com.portfolio.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {


    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}