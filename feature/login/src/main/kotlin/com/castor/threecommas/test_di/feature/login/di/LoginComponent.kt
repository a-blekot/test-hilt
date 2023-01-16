package com.castor.threecommas.test_di.feature.login.di

import com.castor.threecommas.test_di.core.analytics.api.AnalyticsService
import com.castor.threecommas.test_di.core.di.FeatureScope
import com.castor.threecommas.test_di.feature.login.LoginFragment
import com.castor.threecommas.test_di.feature.login.LoginViewModel
import com.castor.threecommas.test_di.feature.login.name.LoginNameFragment
import com.castor.threecommas.test_di.feature.login.name.LoginNameViewModel
import com.castor.threecommas.test_di.feature.login.password.LoginPasswordFragment
import dagger.Subcomponent
import javax.inject.Inject


@[Subcomponent(modules = [LoginModule::class]) FeatureScope]
interface LoginComponent {
    fun inject(fragment: LoginFragment)
    fun inject(fragment: LoginNameFragment)
    fun inject(fragment: LoginPasswordFragment)

    fun loginViewModelFactory(): LoginViewModel.Factory
    fun loginNameViewModel(): LoginNameViewModel

//    @Subcomponent.Builder
//    interface Builder {
//        // The below module injection API is option if the
//        // ChildModule doesn't take parameter.
//        // But it is required if the Child module need to have
//        // parameter
//        fun childModule(module: LoginModule): Builder
//        fun build(): LoginComponent
//    }
}

@FeatureScope
class LoginRepository @Inject constructor(
    val userRepository: UserRepository,
    val analyticsService: AnalyticsService
)

@FeatureScope
class UserRepository @Inject constructor()