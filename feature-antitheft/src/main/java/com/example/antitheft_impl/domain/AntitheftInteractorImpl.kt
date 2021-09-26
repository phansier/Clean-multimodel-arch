package com.example.antitheft_impl.domain

import com.example.antitheft_impl.domain.models.AntitheftModel
import com.example.core.di.general.PerFeature
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@PerFeature
internal class AntitheftInteractorImpl @Inject constructor(private val antitheftRepository: AntitheftRepository) : AntitheftInteractor {
    override fun doAntitheftWork(): Single<AntitheftModel> {
        return antitheftRepository.doAntitheftLowLevelWork()
                .flatMap { antitheftModel: AntitheftModel -> doSomeLogic(antitheftModel) }
    }

    private fun doSomeLogic(antitheftModel: AntitheftModel): Single<AntitheftModel> {
        return Single.timer(3000, TimeUnit.MILLISECONDS)
                .map { antitheftModel }
    }
}