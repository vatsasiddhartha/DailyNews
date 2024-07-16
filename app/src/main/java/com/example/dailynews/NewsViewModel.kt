package com.example.dailynews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class NewsViewModel : ViewModel() {
    private val _articles = MutableLiveData<List<ArticleX>>()
    val articles: LiveData<List<ArticleX>> get() = _articles

    init {
        fetchEverything()
    }

    private fun fetchEverything() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getEverything(
                    query = "tesla",
                    from = "2024-06-16",
                    sortBy = "publishedAt",
                    apiKey = "914b025403a845f7ac9abd65b4b13fae"
                )
                _articles.postValue(response.articles)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}