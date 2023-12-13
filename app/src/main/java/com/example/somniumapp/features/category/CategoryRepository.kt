package com.example.somniumapp.features.category

import com.example.somniumapp.features.category.model.CreateCategoryResponse
import com.example.somniumapp.features.category.model.DeleteCategoryResponse
import com.example.somniumapp.features.category.model.EditCategoryResponse
import com.example.somniumapp.features.category.model.GetCategoriesResponse

interface CategoryRepository {
    fun getCategories():List<GetCategoriesResponse>
    fun createCategory(name: String): CreateCategoryResponse?
    fun deleteCategory(name: String): DeleteCategoryResponse?
    fun editCategory(name: String): EditCategoryResponse?
}