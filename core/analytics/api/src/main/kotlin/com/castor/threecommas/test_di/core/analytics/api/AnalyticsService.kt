package com.castor.threecommas.test_di.core.analytics.api

interface AnalyticsService {
    fun logEvent(name: String, params: Map<String, Any>)
}