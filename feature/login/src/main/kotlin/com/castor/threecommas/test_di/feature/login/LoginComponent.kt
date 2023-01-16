package com.castor.threecommas.test_di.feature.login

import androidx.fragment.app.Fragment
import com.castor.threecommas.test_di.core.analytics.api.AnalyticsService
import com.castor.threecommas.test_di.core.di.ComponentHolder
import com.castor.threecommas.test_di.core.di.FeatureScope
import dagger.Subcomponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject


@[EntryPoint InstallIn(ActivityComponent::class)]
interface LoginEntryPoint {
    fun loginComponent(module: LoginModule): LoginComponent
}

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

object LoginComponentHolder : ComponentHolder {

    var component: LoginComponent? = null
        private set

    override fun reset() {
        component = null
    }

    fun inject(fragment: LoginFragment) {
        createIfNeeded(fragment)
        component!!.inject(fragment)
    }

    fun inject(fragment: LoginNameFragment) {
        createIfNeeded(fragment)
        component!!.inject(fragment)
    }

    fun inject(fragment: LoginPasswordFragment) {
        createIfNeeded(fragment)
        component!!.inject(fragment)
    }

    private fun createIfNeeded(fragment: Fragment) {
        if (component == null) {
            synchronized(this) {
                if (component == null) {
                    component = EntryPointAccessors
                        .fromActivity(fragment.requireActivity(), LoginEntryPoint::class.java)
                        .loginComponent(LoginModule())
//                        .childModule(LoginModule())
//                        .build()
                }
            }
        }
    }
}

@FeatureScope
class LoginRepository @Inject constructor(
    val userRepository: UserRepository,
    val analyticsService: AnalyticsService
)

@FeatureScope
class UserRepository @Inject constructor()