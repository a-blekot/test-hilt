package com.castor.threecommas.test_di.feature.login.di

import com.castor.threecommas.test_di.core.analytics.api.AnalyticsService
import com.castor.threecommas.test_di.core.di.FeatureScope
import com.castor.threecommas.test_di.feature.login.LoginFragment
import com.castor.threecommas.test_di.feature.login.LoginViewModel
import com.castor.threecommas.test_di.feature.login.name.LoginNameFragment
import com.castor.threecommas.test_di.feature.login.name.LoginNameViewModel
import com.castor.threecommas.test_di.feature.login.password.LoginPasswordFragment
import dagger.Component
import javax.inject.Inject

@FeatureScope
@Component(
    dependencies = [LoginEntryPoint::class],
    modules = [LoginModule::class]
)
interface LoginComponent {
    fun inject(fragment: LoginFragment)
    fun inject(fragment: LoginNameFragment)
    fun inject(fragment: LoginPasswordFragment)

    fun loginViewModel(): LoginViewModel
    fun loginNameViewModel(): LoginNameViewModel
}

@FeatureScope
class LoginRepository @Inject constructor(
    val userRepository: UserRepository,
    val analyticsService: AnalyticsService
)

@FeatureScope
class UserRepository @Inject constructor()
