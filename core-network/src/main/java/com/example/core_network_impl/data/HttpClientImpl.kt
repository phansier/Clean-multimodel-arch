package com.example.core_network_impl.data

import com.example.core_network_api.data.HttpClient
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

internal class HttpClientImpl @Inject constructor() : HttpClient {
    override suspend fun doAnyRequest(): Any {
        delay(300.milliseconds)
        return Any()
    }
}