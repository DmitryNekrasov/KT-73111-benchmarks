package org.example

import kotlinx.benchmark.*

@State(Scope.Benchmark)
open class LongToBigIntegerBenchmark {
    @Param(
        "lessThenLongMaxValue",
        "moreThenLongMaxValue"
    )
    lateinit var caseId: String

    val value: Long
        get() = when (caseId) {
            "lessThenLongMaxValue" -> Long.MAX_VALUE / 2
            "moreThenLongMaxValue" -> Long.MAX_VALUE
            else -> error("Invalid caseId: $caseId")
        }

    @Benchmark
    fun longToBigInteger() = value.toBigInteger()
}
