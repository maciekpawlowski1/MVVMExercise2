package com.example.mvvmexercise2.domain.useCase

import com.example.mvvmexercise2.domain.model.Money
import com.example.mvvmexercise2.domain.model.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.math.BigDecimal
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class StreamPrices {
    private fun variant1() =
        listOf(
            Product(
                id = "id1",
                name = "Czekolada",
                price =
                    Money(
                        amount = BigDecimal(Random.nextInt(103, 110)).setScale(2),
                        currency = "PLN",
                    ),
            ),
            Product(
                id = "id2",
                name = "Masło",
                price =
                    Money(
                        amount = BigDecimal(Random.nextInt(102, 111)).setScale(2),
                        currency = "PLN",
                    ),
            ),
            Product(
                id = "id3",
                name = "Woda gazowana",
                price =
                    Money(
                        amount = BigDecimal(Random.nextInt(260, 280)).setScale(2),
                        currency = "PLN",
                    ),
            ),
        )

    operator fun invoke(): Flow<List<Product>> =
        flow {
            while (true) {
                emit(variant1())
                delay(1.seconds)
            }
        }
}
