package com.example.newsappdagger.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappdagger.models.NewsResponse
import com.example.newsappdagger.repositories.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val repository: NewsRepository): ViewModel() {
    private var newsResponse = MutableLiveData<NewsResponse>()
    val newsResponseLiveData: LiveData<NewsResponse> get() = newsResponse

    fun getLatestNews() = viewModelScope.launch {
        val response = repository.getLatestNews()
        if (response.body() != null) {
            newsResponse.value = response.body()
        }
    }


}