package com.example.somniumapp.features.article

import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleRepositoryHttpImpl(private val httpClient: HttpClient): ArticleRepository {
    override suspend fun getArticle(id: String): GetArticleResponse {
        return httpClient.get("articles/$id").body()
    }

    override suspend fun getArticles(category: String): GetArticlesByCategoryResponse {
        return httpClient.get("categories/$category/articles").body()
    }

}