package com.example.antitheft_impl.domain

import com.example.antitheft_impl.domain.models.AntitheftModel
import com.example.core.di.general.PerFeature
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@PerFeature
internal class AntitheftInteractorImpl @Inject constructor(private val antitheftRepository: AntitheftRepository) :
    AntitheftInteractor {
    override suspend fun doAntitheftWork(): AntitheftModel {
        val antitheftModel = antitheftRepository.doAntitheftLowLevelWork()
        return doSomeLogic(antitheftModel)
    }

    private suspend fun doSomeLogic(antitheftModel: AntitheftModel): AntitheftModel {
        delay(300.milliseconds)
        return antitheftModel
    }
}