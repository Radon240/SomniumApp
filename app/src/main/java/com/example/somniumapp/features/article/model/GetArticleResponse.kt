package com.example.somniumapp.features.article.model
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class GetArticleResponse(
    val id: String,
    val title: String,
    val content: String,
    val contributors: List<Author>,
    val timestamp: Instant,
    val categories: List<String>
){
    @Serializable
    data class Author(
        val id: String,
        val name: String
    )
}