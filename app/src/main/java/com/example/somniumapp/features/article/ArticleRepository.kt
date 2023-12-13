package com.example.somniumapp.features.article

import com.example.somniumapp.features.article.model.DeleteArticleResponse
import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.CreateArticleResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse

interface ArticleRepository {
    fun getArticle(title:String): GetArticleResponse?
    fun getArticles(category: String): List<GetArticlesByCategoryResponse>?
    fun deleteArticle(title:String): DeleteArticleResponse?
    fun createArticle(): CreateArticleResponse?
}