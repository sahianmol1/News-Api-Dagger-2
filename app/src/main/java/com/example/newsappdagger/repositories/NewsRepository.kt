package com.example.newsappdagger.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsappdagger.data.NewsApi
import com.example.newsappdagger.models.NewsResponse
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    suspend fun getLatestNews() =
        newsApi.getLatestNews()

}