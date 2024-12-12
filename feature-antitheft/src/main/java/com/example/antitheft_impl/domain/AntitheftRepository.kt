package com.example.antitheft_impl.domain

import com.example.antitheft_impl.domain.models.AntitheftModel


internal interface AntitheftRepository {
    suspend fun doAntitheftLowLevelWork(): AntitheftModel
}