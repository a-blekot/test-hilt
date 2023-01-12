package com.castor.threecommas.test_di.core.analytics.impl

import android.content.Context
import android.util.Log
import com.castor.threecommas.test_di.core.analytics.api.AnalyticsService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FirebaseAnalyticsService @Inject constructor(
    @ApplicationContext context: Context
): AnalyticsService {

    init {
        Log.d("FirebaseAnalyticsService", "context = $context")
    }

    override fun logEvent(name: String, params: Map<String, Any>) {
        Log.d("FirebaseAnalyticsService", "$this event -> $name: $params")
    }
}