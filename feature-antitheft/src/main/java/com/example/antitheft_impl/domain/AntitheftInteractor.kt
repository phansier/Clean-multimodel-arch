package com.example.antitheft_impl.domain

import com.example.antitheft_impl.domain.models.AntitheftModel


internal interface AntitheftInteractor {
    suspend fun doAntitheftWork(): AntitheftModel
}