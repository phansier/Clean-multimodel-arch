package com.example.scanner_example.di

import com.example.core.di.app.CoreUtilsComponent
import com.example.core.utils.SomeUtils
import com.example.core_db_api.data.DbClient
import com.example.core_network_api.data.HttpClient
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.scanner_impl.di.ScannerFeatureDependencies
import com.example.scanner_example.fake.DbClientFake
import com.example.scanner_example.fake.HttpClientFake
import com.example.scanner_example.fake.PurchaseInteractorFake

class ScannerFeatureDependenciesFake : ScannerFeatureDependencies {
    override fun dbClient(): DbClient {
        return DbClientFake()
    }

    override fun httpClient(): HttpClient {
        return HttpClientFake()
    }

    override fun someUtils(): SomeUtils {
        return CoreUtilsComponent.get().someUtils()
    }

    override fun purchaseInteractor(): PurchaseInteractor {
        return PurchaseInteractorFake()
    }
}