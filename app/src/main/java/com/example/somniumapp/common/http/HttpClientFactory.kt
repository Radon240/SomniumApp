package com.example.somniumapp.common.http

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory {
    fun create(): HttpClient{
        return HttpClient(Android){
            install(ContentNegotiation){
                json(Json{
                    prettyPrint = true
                    isLenient = true
                })
            }
            defaultRequest {
                url("http://10.0.2.2:5216/api/")
            }
        }
    }
}