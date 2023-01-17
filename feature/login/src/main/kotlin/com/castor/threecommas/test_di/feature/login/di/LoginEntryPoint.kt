package com.castor.threecommas.test_di.feature.login.di

import com.castor.threecommas.test_di.core.analytics.api.AnalyticsService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@[EntryPoint InstallIn(ActivityComponent::class)]
interface LoginEntryPoint {
    val analyticsService: AnalyticsService
}