package com.example.somniumapp.features.article

import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.GetArticleRevisionsResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse
import java.time.LocalDateTime

class ArticleRepositoryInMemoryImpl : ArticleRepository {
    override fun getArticle(title: String): GetArticleResponse? {
        return listOf(
            GetArticleResponse("a", "test1", "div2005", LocalDateTime.now(), listOf())
        ).find {
            e -> e.title == title
        }
    }

    override fun getArticleByCategory(name: String): List<GetArticlesByCategoryResponse>? {
        return when (name){
            "" -> listOf(GetArticlesByCategoryResponse("b"))
            else -> null
        }
    }

    override fun getArticleByRevision(title: String, revisionId: String): GetArticleResponse? {
        return listOf(

        )
    }

    override fun getArticleRevisions(title: String): List<GetArticleRevisionsResponse>? {
        TODO("Not yet implemented")
    }
}