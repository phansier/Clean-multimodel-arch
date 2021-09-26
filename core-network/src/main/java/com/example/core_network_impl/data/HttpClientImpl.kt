package com.example.core_network_impl.data

import com.example.core_network_api.data.HttpClient
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class HttpClientImpl @Inject constructor() : HttpClient {
    override fun doAnyRequest(): Single<Any> {
        return Single.timer(300, TimeUnit.MILLISECONDS)
                .map { Any() }
    }
}