package com.example.coroutinedemo.data

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)