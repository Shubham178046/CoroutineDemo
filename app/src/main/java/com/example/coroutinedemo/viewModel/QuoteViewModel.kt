package com.example.coroutinedemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinedemo.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.coroutinedemo.data.Quote

class QuoteViewModel : ViewModel() {
    val TAG = "MovieViewModel"
    val movies : LiveData<List<Quote>?> = MutableLiveData<List<Quote>>()
    init {
        viewModelScope.launch {
            movies as MutableLiveData
            val moviesData = async {  getQuotes() }
            val data = moviesData.await()
            movies.value = data
        }
    }

     private suspend fun getQuotes() : List<Quote>
    {
            return withContext(Dispatchers.IO){
                android.util.Log.e(TAG, "Getting Movies")
                ApiInterface().getQuotes().body()!!.quotes
            }
    }
}