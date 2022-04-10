package com.example.newsappdagger.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsappdagger.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines/")
    suspend fun getLatestNews(
        @Query("language") language: String = "en",
        @Query("apiKey") apiKey: String = "5a574596b5434fd282e6f6c1c04d50c2",
    ): Response<NewsResponse>
}