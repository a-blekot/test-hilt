package com.castor.threecommas.test_di.core.analytics.impl.di

import com.castor.threecommas.test_di.core.analytics.api.AnalyticsService
import com.castor.threecommas.test_di.core.analytics.impl.FirebaseAnalyticsService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

//@Module
//@InstallIn(ActivityRetainedComponent::class)
//class AnalyticsModule {
//
//    @[Provides]
//    fun provideAnalyticsService(
//        @ApplicationContext context: Context
//    ): AnalyticsService = FirebaseAnalyticsService(context)
//}

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AnalyticsModule {

    @[Binds]
    abstract fun bindAnalyticsService(
        firebaseAnalyticsService: FirebaseAnalyticsService
    ): AnalyticsService
}