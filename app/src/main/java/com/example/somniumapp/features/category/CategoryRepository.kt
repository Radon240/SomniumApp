package com.example.somniumapp.features.category

import com.example.somniumapp.features.category.model.GetCategoriesResponse

interface CategoryRepository {
    fun getCategories():List<GetCategoriesResponse>
}