package com.example.somniumapp.features.article

import com.example.somniumapp.features.article.model.CreateArticleResponse
import com.example.somniumapp.features.article.model.DeleteArticleResponse
import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.GetArticleRevisionsResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse
import java.time.LocalDateTime

class ArticleRepositoryInMemoryImpl : ArticleRepository {
    override fun getArticle(title: String): GetArticleResponse? {
        return listOf(
            GetArticleResponse("a", "test content", "div2005", LocalDateTime.now(), listOf())
        ).find {
                e -> e.title == title
        }
    }
    override fun deleteArticle(title: String): DeleteArticleResponse? {
        return deleteArticle("a")
    }

    override fun createArticle(): CreateArticleResponse? {
        return CreateArticleResponse("test")
    }

    override fun getArticles(category: String): List<GetArticlesByCategoryResponse>?{
        val articlesByCategory = mapOf(
            "FAQ" to listOf(
                GetArticlesByCategoryResponse("Статья 1"),
                GetArticlesByCategoryResponse("Статья 2")
            ),
            "Gameplay" to listOf(
                GetArticlesByCategoryResponse("В ожидании новогоднего Ивента"),
                GetArticlesByCategoryResponse("Мыши зополонили спавн"),
                GetArticlesByCategoryResponse("Правила"),
                GetArticlesByCategoryResponse("В ожидании новогоднего Ивента"),
                GetArticlesByCategoryResponse("Мыши зополонили спавн"),
                GetArticlesByCategoryResponse("Правила"),
                GetArticlesByCategoryResponse("В ожидании новогоднего Ивента"),
                GetArticlesByCategoryResponse("Мыши зополонили спавн"),
                GetArticlesByCategoryResponse("Правила"),
                GetArticlesByCategoryResponse("В ожидании новогоднего Ивента"),
                GetArticlesByCategoryResponse("Мыши зополонили спавн"),
                GetArticlesByCategoryResponse("Правила"),
                GetArticlesByCategoryResponse("В ожидании новогоднего Ивента"),
                GetArticlesByCategoryResponse("Мыши зополонили спавн"),
                GetArticlesByCategoryResponse("Правила"),
                GetArticlesByCategoryResponse("В ожидании новогоднего Ивента"),
                GetArticlesByCategoryResponse("Мыши зополонили спавн"),
                GetArticlesByCategoryResponse("Правила"),
                GetArticlesByCategoryResponse("В ожидании новогоднего Ивента"),
                GetArticlesByCategoryResponse("Мыши зополонили спавн"),
                GetArticlesByCategoryResponse("Правила")
            ),
            "Donate" to listOf(
                GetArticlesByCategoryResponse("Как купить проходку"),
                GetArticlesByCategoryResponse("Как бесплатно получить админку")
            )
        )
        return articlesByCategory[category]
    }
}