package com.example.somniumapp.features.category.model

import kotlinx.serialization.Serializable

@Serializable
data class GetCategoriesResponse(
    val data: List<Element>
){
    @Serializable
    data class Element(
        val id: String,
        val name: String,
        val parentId: String?
    )
}
