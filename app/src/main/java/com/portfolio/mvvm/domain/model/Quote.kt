package com.portfolio.mvvm.domain.model

import com.portfolio.mvvm.data.database.entities.QuoteEntity
import com.portfolio.mvvm.data.model.models.QuoteModel

data class Quote(val quote:String, val author:String)

fun QuoteModel.toDomain() =Quote(quote,author)

fun QuoteEntity.toDomain() = Quote(quote,author)