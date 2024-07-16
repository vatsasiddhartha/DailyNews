package com.example.dailynews

import retrofit2.http.GET
import retrofit2.http.Query


data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleX>
)

interface ApiService {
    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse
}
