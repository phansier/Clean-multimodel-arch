package com.example.purchase_impl.domain

import com.example.core.di.general.PerFeature
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_api.domain.models.PurchaseModel
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@PerFeature
internal class PurchaseInteractorImpl
@Inject constructor(private val purchaseRepository: PurchaseRepository) : PurchaseInteractor {
    override suspend fun makePurchase(): PurchaseModel {
        val purchaseModel = purchaseRepository.makePurchaseInStore()
        return doSomeLogic(purchaseModel)
    }

    private suspend fun doSomeLogic(purchaseModel: PurchaseModel): PurchaseModel {
        delay(300.milliseconds)
        return purchaseModel
    }
}