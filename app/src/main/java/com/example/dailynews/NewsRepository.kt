package com.example.dailynews

class NewsRepository {
    suspend fun getTopHeadlines(country: String, apiKey: String): NewsResponse {
        return RetrofitInstance.api.getTopHeadlines(country, apiKey)
    }
}