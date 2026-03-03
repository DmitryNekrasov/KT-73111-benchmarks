package org.example

import kotlinx.benchmark.*

@State(Scope.Benchmark)
open class ULongToBigIntegerBenchmark {
    @Param(
        "lessThenLongMaxValueEven",
        "lessThenLongMaxValueOdd",
        "moreThenLongMaxValueEven",
        "moreThenLongMaxValueOdd"
    )
    lateinit var caseId: String

    val input: ULong
        get() = when (caseId) {
            "lessThenLongMaxValueEven" -> ((Long.MAX_VALUE.toULong() - (Long.MAX_VALUE / 2).toULong()) shr 1) shl 1
            "lessThenLongMaxValueOdd" -> (((Long.MAX_VALUE.toULong() - (Long.MAX_VALUE / 2).toULong()) shr 1) shl 1) + 1uL
            "moreThenLongMaxValueEven" -> ((Long.MAX_VALUE.toULong() + (Long.MAX_VALUE / 2).toULong()) shr 1) shl 1
            "moreThenLongMaxValueOdd" -> (((Long.MAX_VALUE.toULong() + (Long.MAX_VALUE / 2).toULong()) shr 1) shl 1) + 1uL
            else -> error("Invalid caseId: $caseId")
        }

    private var value: ULong = 0uL

    @Setup
    fun setup() {
        value = input
        println("Case: $caseId; value = $value")
    }

    @Benchmark
    fun ulongToBigInteger() = value.toBigInteger()
}
