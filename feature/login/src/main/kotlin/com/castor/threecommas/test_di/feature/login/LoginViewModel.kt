package com.castor.threecommas.test_di.feature.login

import androidx.lifecycle.ViewModel
import com.castor.threecommas.test_di.core.utils.Calculator
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class LoginViewModel @AssistedInject constructor(
//    @Assisted savedStateHandle: SavedStateHandle,
    var loginModuleInterface: LoginModuleInterface,
    var loginRepository: LoginRepository,
    var calculator: Calculator

) : ViewModel() {

    val superText: String
        get() {
            val sb = StringBuilder(50)
            sb.append(loginModuleInterface.msg)
            sb.append("\nLoginViewModel ${this.address}")
            sb.append("\nloginModuleInterface ${loginModuleInterface.address}")
            sb.append("\nloginRepository ${loginRepository.address}")
            sb.append("\nuserRepository ${loginRepository.userRepository.address}")
            sb.append("\nanalyticsService ${loginRepository.analyticsService.address}")
            return sb.toString()
        }

    @AssistedFactory
    interface Factory {
//        fun create(savedStateHandle: SavedStateHandle): LoginViewModel
        fun create(): LoginViewModel
    }
}
