package com.castor.threecommas.test_di.ui.dashboard.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardDetailsViewModel @Inject constructor(
) : ViewModel() {
    val text: String get() = "DashboardDetailsViewModel"
}