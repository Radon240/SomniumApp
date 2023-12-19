package com.example.somniumapp.features.category

import com.example.somniumapp.features.category.model.GetCategoriesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CategoryRepositoryHttpImpl(private val httpClient: HttpClient) : CategoryRepository {
    override suspend fun getCategories(): GetCategoriesResponse {
        return httpClient.get("categories").body()
    }
}