package com.example.somniumapp.features.category

import com.example.somniumapp.features.category.model.CreateCategoryResponse
import com.example.somniumapp.features.category.model.DeleteCategoryResponse
import com.example.somniumapp.features.category.model.EditCategoryResponse
import com.example.somniumapp.features.category.model.GetCategoriesResponse

interface CategoryRepository {
    suspend fun getCategories():GetCategoriesResponse
}

