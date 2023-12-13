package com.example.somniumapp.features.article.model
import java.time.LocalDateTime

data class GetArticleResponse(
    val title: String,
    val content: String,
    val revisionAuthor: String,
    val timeStamp: LocalDateTime,
    val categories: List<String>
)