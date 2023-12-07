package com.example.somniumapp.features.category

import com.example.somniumapp.features.category.model.GetCategoriesResponse

class CategoryRepositoryInMemoryImpl : CategoryRepository {
    override fun getCategories(): List<GetCategoriesResponse> {
        return listOf(
            GetCategoriesResponse("FAQ", null),
            GetCategoriesResponse("Gameplay", null),
            GetCategoriesResponse("Enchantments", "Gameplay")
        )
    }
}