package com.example.purchase_api.domain

import com.example.purchase_api.domain.models.PurchaseModel

interface PurchaseInteractor {
    suspend fun makePurchase(): PurchaseModel
}