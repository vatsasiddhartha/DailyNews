package com.example.dailynews

data class Article(
    val articles: List<ArticleX>,
    val status: String,
    val totalResults: Int
)