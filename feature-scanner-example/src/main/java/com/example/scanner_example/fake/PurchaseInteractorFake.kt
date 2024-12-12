package com.example.scanner_example.fake

import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_api.domain.models.PurchaseModel
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class PurchaseInteractorFake : PurchaseInteractor {
    override suspend fun makePurchase(): PurchaseModel {
        delay(100.milliseconds)
        return PurchaseModel()
    }
}