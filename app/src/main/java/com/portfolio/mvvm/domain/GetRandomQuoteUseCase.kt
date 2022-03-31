package com.portfolio.mvvm.domain

import com.portfolio.mvvm.data.model.QuoteRepository
import com.portfolio.mvvm.data.model.models.QuoteModel
import com.portfolio.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(quotes.isNullOrEmpty()){
            return null
        }
        val randomNumber = (quotes.indices).random()
        return quotes[randomNumber]
    }
}