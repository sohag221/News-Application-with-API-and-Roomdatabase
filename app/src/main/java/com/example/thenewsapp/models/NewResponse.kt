package com.example.thenewsapp.models

data class NewResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)