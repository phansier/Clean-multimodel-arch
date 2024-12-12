package com.example.purchase_impl.domain

import com.example.purchase_api.domain.models.PurchaseModel

internal interface PurchaseRepository {
    suspend fun makePurchaseInStore(): PurchaseModel
}