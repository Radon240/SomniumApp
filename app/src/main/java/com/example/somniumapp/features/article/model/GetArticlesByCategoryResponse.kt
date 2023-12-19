package com.example.somniumapp.features.article.model

import kotlinx.serialization.Serializable

@Serializable
data class GetArticlesByCategoryResponse(
    val data: List<Element>
){
    @Serializable
    data class Element(
    val id: String,
    val title: String
)
}
