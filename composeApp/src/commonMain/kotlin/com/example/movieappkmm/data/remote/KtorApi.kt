package com.example.movieappkmm.data.remote

import com.example.movieappkmm.util.Constants.API_KEY
import com.example.movieappkmm.util.Constants.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
internal abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path : String) {
        url{
            takeFrom(BASE_URL)
            path("3",path)
            parameter("api_key",API_KEY)
        }
    }

}