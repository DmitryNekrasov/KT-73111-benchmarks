package org.example

import kotlinx.benchmark.*

@State(Scope.Benchmark)
open class LongToBigIntegerBenchmark {
    @Param(
        "lessThenLongMaxValue",
        "moreThenLongMaxValue"
    )
    lateinit var caseId: String

    val input: Long
        get() = when (caseId) {
            "lessThenLongMaxValue" -> Long.MAX_VALUE / 2
            "moreThenLongMaxValue" -> Long.MAX_VALUE
            else -> error("Invalid caseId: $caseId")
        }

    private var value: Long = 0L

    @Setup
    fun setup() {
        value = input
        println("Case: $caseId; value = $value")
    }

    @Benchmark
    fun longToBigInteger() = value.toBigInteger()
}
