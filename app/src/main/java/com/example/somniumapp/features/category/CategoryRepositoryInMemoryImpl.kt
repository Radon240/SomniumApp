package com.example.somniumapp.features.category

import com.example.somniumapp.features.category.model.CreateCategoryResponse
import com.example.somniumapp.features.category.model.DeleteCategoryResponse
import com.example.somniumapp.features.category.model.EditCategoryResponse
import com.example.somniumapp.features.category.model.GetCategoriesResponse

class CategoryRepositoryInMemoryImpl : CategoryRepository {
    override fun getCategories(): List<GetCategoriesResponse> {
        return listOf(
            GetCategoriesResponse("FAQ", null),
            GetCategoriesResponse("Gameplay", null),
            GetCategoriesResponse("Enchantments", "Gameplay")
        )
    }

    override fun createCategory(name: String): CreateCategoryResponse? {
        return CreateCategoryResponse("Category 1", null)
    }

    override fun deleteCategory(name: String): DeleteCategoryResponse? {
        return DeleteCategoryResponse("Category 1")
    }

    override fun editCategory(name: String): EditCategoryResponse? {
        return EditCategoryResponse("Category 1", null)
    }


}