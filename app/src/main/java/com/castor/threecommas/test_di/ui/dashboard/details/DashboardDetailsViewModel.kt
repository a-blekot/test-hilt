package com.castor.threecommas.test_di.ui.dashboard.details

import androidx.lifecycle.ViewModel
import com.castor.threecommas.test_di.feature.dashboard.details.DashboardDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardDetailsViewModel @Inject constructor(
    private val repo: DashboardDetailsRepository
) : ViewModel() {
    val text: String get() = repo.text
}