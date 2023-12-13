package com.example.somniumapp.di

import com.example.somniumapp.features.article.ArticleRepository
import com.example.somniumapp.features.article.ArticleRepositoryInMemoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module{
    factoryOf(::ArticleRepositoryInMemoryImpl) bind ArticleRepository::class
}