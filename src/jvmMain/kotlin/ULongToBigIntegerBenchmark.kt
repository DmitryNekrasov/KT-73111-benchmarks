package org.example

import kotlinx.benchmark.*

@State(Scope.Benchmark)
open class ULongToBigIntegerBenchmark {
    @Param(
        "lessThenLongMaxValue",
        "moreThenLongMaxValue"
    )
    lateinit var caseId: String

    val input: ULong
        get() = when (caseId) {
            "lessThenLongMaxValue" -> Long.MAX_VALUE.toULong() - (Long.MAX_VALUE / 2).toULong()
            "moreThenLongMaxValue" -> Long.MAX_VALUE.toULong() + (Long.MAX_VALUE / 2).toULong()
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
