package com.example.somniumapp.features.category

import android.sax.Element
import com.example.somniumapp.features.category.model.CreateCategoryResponse
import com.example.somniumapp.features.category.model.DeleteCategoryResponse
import com.example.somniumapp.features.category.model.EditCategoryResponse
import com.example.somniumapp.features.category.model.GetCategoriesResponse

class CategoryRepositoryInMemoryImpl : CategoryRepository {
    override suspend fun getCategories(): GetCategoriesResponse {
        return GetCategoriesResponse(
            listOf(
                GetCategoriesResponse.Element("001", "FAQ", null),
                GetCategoriesResponse.Element("002", "Gameplay", null),
                GetCategoriesResponse.Element("003", "Enchantments", "Gameplay")
            )
        )
    }
}