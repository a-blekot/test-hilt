package com.castor.threecommas.test_di.feature.dashboard.details

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DashboardDetailsRepository @Inject constructor() {

    private val timeCreated = System.currentTimeMillis()

    val text: String
        get() = "DashboardDetailsRepository (timeCreated=$timeCreated): $this"
}