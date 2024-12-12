package com.example.purchase_impl.data

import com.example.core.di.general.PerFeature
import com.example.core_network_api.data.HttpClient
import com.example.purchase_api.domain.models.PurchaseModel
import com.example.purchase_impl.domain.PurchaseRepository
import javax.inject.Inject

@PerFeature
internal class PurchaseRepositoryImpl
@Inject constructor(private val httpClient: HttpClient) : PurchaseRepository {
    override suspend fun makePurchaseInStore(): PurchaseModel {
        httpClient.doAnyRequest()
        return PurchaseModel()

    }
}