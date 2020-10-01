package com.example.coroutinedemo.api

import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder
import com.example.coroutinedemo.data.QuotesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiInterface {
    @GET("mvvm/quotes")
    suspend fun getQuotes():Response<QuotesResponse>

    companion object {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        operator fun invoke(): ApiInterface {
            android.util.Log.e("TAG", "Getting Movies Call")
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.simplifiedcoding.in/course-apis/")
                .client(okHttpClient)
                .build()
                .create(ApiInterface::class.java)
        }
    }
}