package com.portfolio.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portfolio.mvvm.data.model.models.QuoteModel
import com.portfolio.mvvm.domain.GetQuotesUseCase
import com.portfolio.mvvm.domain.GetRandomQuoteUseCase
import com.portfolio.mvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase : GetQuotesUseCase,
    private val getRandomQuoteUseCase : GetRandomQuoteUseCase) : ViewModel(){

    val quoteModel = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>()



    fun onCreate() {
        viewModelScope.launch {
           isLoading.postValue(true)
            val result = getQuoteUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }
    }

    fun randomQuote(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote:Quote? = getRandomQuoteUseCase()
            if(quote!=null){
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }
    }


}