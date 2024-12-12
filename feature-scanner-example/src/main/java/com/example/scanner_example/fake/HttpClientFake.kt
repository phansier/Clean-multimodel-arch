package com.example.scanner_example.fake

import com.example.core_network_api.data.HttpClient
import javax.inject.Inject

class HttpClientFake @Inject constructor() : HttpClient {
    override suspend fun doAnyRequest(): Any = Any()
}