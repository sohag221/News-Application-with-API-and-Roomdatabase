package com.example.thenewsapp.repository

import com.example.thenewsapp.api.RetrofitInstance
import com.example.thenewsapp.db.ArticleDatabase
import com.example.thenewsapp.models.Article

class NewsRepository(val db:ArticleDatabase) {

        suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
            RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

        suspend fun searchNews(searchQuery: String, pageNumber: Int) =
            RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

        suspend fun upsert(article: Article) = db.getArticleDAO().upsert(article)

        fun getSavedNews() = db.getArticleDAO().getAllArticles()

        suspend fun deleteArticle(article: Article) = db.getArticleDAO().deleteArticle(article)
}