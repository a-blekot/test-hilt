package com.castor.threecommas.test_di.feature.login.name

import androidx.lifecycle.ViewModel
import com.castor.threecommas.test_di.core.utils.Calculator
import com.castor.threecommas.test_di.feature.login.di.LoginModuleInterface
import com.castor.threecommas.test_di.feature.login.di.LoginRepository
import com.castor.threecommas.test_di.feature.login.address
import javax.inject.Inject

class LoginNameViewModel @Inject constructor(
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
}