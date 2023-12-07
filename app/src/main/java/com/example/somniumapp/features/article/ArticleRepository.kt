package com.example.somniumapp.features.article

import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.GetArticleRevisionsResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse

interface ArticleRepository {
    fun getArticle(title:String): GetArticleResponse?
    fun getArticleByCategory(name:String): List<GetArticlesByCategoryResponse>?
    fun getArticleByRevision(title:String, revisionId: String): GetArticleResponse?
    fun getArticleRevisions(title:String):List<GetArticleRevisionsResponse>?
}