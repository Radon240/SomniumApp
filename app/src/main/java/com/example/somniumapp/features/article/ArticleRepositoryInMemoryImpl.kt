package com.example.somniumapp.features.article

import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


class ArticleRepositoryInMemoryImpl : ArticleRepository {
    override suspend fun getArticle(id: String): GetArticleResponse {
        return listOf(
            GetArticleResponse("011", "Статья 1", "Контент к статье 1", listOf(), Clock.System.now(), listOf()),
            GetArticleResponse("021", "Статья 2", "Контент к статье 2", listOf(), Clock.System.now(), listOf()),
            GetArticleResponse("012", "Нового года не будет", "", listOf(), Clock.System.now(), listOf())
        ).find {
                e -> e.id == id
        } ?: return GetArticleResponse("ERROR", "Ошибка", "Выбранной статьи не существует", listOf(), Clock.System.now(), listOf())
    }

    override suspend fun getArticles(category: String): GetArticlesByCategoryResponse {
        val articlesByCategory = mapOf(
            "FAQ" to listOf(
                GetArticlesByCategoryResponse.Element("011", "Статья 1"),
                GetArticlesByCategoryResponse.Element("021", "Статья 2")
            ),
            "Gameplay" to listOf(
                GetArticlesByCategoryResponse.Element("012", "Нового года не будет"),
                GetArticlesByCategoryResponse.Element("012", "Новый год будет"),
                GetArticlesByCategoryResponse.Element("012", "Нового года не будет"),
                GetArticlesByCategoryResponse.Element("042", "Новый год будет"),
                GetArticlesByCategoryResponse.Element("052", "Нового года не будет"),
                GetArticlesByCategoryResponse.Element("062", "Новый год будет"),
                GetArticlesByCategoryResponse.Element("072", "Нового года не будет"),
                GetArticlesByCategoryResponse.Element("082", "Новый год будет"),
                GetArticlesByCategoryResponse.Element("092", "Нового года не будет"),
                GetArticlesByCategoryResponse.Element("102", "Новый год будет"),
                GetArticlesByCategoryResponse.Element("112", "Нового года не будет"),
                GetArticlesByCategoryResponse.Element("122", "Новый год будет"),
                GetArticlesByCategoryResponse.Element("112", "Нового года не будет")
            ),
            "Donate" to listOf(
                GetArticlesByCategoryResponse.Element("013", "Как получить админку"),
                GetArticlesByCategoryResponse.Element("023", "Заберите мои деньги!")
            )
        )
        return GetArticlesByCategoryResponse(articlesByCategory[category]!!)
    }
}