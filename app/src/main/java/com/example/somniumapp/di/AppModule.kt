package com.example.somniumapp.di

import com.example.somniumapp.common.http.HttpClientFactory
import com.example.somniumapp.features.article.ArticleRepository
import com.example.somniumapp.features.article.ArticleRepositoryHttpImpl
import com.example.somniumapp.features.article.ArticleRepositoryInMemoryImpl
import com.example.somniumapp.features.category.CategoryRepository
import com.example.somniumapp.features.category.CategoryRepositoryHttpImpl
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module{
    single{ HttpClientFactory().create() } bind HttpClient::class
    factoryOf(::ArticleRepositoryHttpImpl) bind ArticleRepository::class
    factoryOf(::CategoryRepositoryHttpImpl) bind CategoryRepository::class
}