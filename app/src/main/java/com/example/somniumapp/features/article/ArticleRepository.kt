package com.example.somniumapp.features.article

import com.example.somniumapp.features.article.model.DeleteArticleResponse
import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.CreateArticleResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse

interface ArticleRepository {
    suspend fun getArticle(id: String): GetArticleResponse
    suspend fun getArticles(category: String): GetArticlesByCategoryResponse
}