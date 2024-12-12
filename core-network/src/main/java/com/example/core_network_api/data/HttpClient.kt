package com.example.core_network_api.data


interface HttpClient {
    suspend fun doAnyRequest(): Any
}