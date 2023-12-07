package com.example.somniumapp.features.article.model

import java.time.LocalDateTime

data class GetArticleRevisionsResponse(
    val revisionId: String,
    val previousRevisionId: String?,
    val author: String,
    val timeStamp: LocalDateTime,
    val reviewer: String
)
