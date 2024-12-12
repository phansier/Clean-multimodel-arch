package com.example.antitheft_impl.repositories_impl

import com.example.antitheft_impl.domain.AntitheftRepository
import com.example.antitheft_impl.domain.models.AntitheftModel
import com.example.core.di.general.PerFeature
import com.example.core_db_api.data.DbClient
import com.example.core_network_api.data.HttpClient

import javax.inject.Inject

@PerFeature
internal class AntitheftRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient,
    private val dbClient: DbClient
) : AntitheftRepository {
    override suspend fun doAntitheftLowLevelWork(): AntitheftModel {
        httpClient.doAnyRequest()
        return AntitheftModel()
    }
}