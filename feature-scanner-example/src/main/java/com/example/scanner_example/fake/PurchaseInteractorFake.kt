package com.example.scanner_example.fake

import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_api.domain.models.PurchaseModel

import java.util.concurrent.TimeUnit

class PurchaseInteractorFake : PurchaseInteractor {
    override fun makePurchase(): Single<PurchaseModel> {
        return Single.timer(100, TimeUnit.MILLISECONDS)
                .map { aLong: Long -> PurchaseModel() }
    }
}