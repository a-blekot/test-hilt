package com.castor.threecommas.test_di.core.utils

import com.castor.threecommas.test_di.core.analytics.api.AnalyticsService
import javax.inject.Inject

class Calculator @Inject constructor(
    private val analyticsService: AnalyticsService
) {
    fun sum(a: Int, b: Int): Int {
        analyticsService.logEvent("calculator", mapOf("number_a" to a, "number_b" to b))
        return a + b
    }
}