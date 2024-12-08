package com.example.mvvmexercise2.domain.model

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
    val currency: String,
)
