package com.portfolio.mvvm.data.model.models

import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("quote") val quote:String,
    @SerializedName("author") val author:String)
