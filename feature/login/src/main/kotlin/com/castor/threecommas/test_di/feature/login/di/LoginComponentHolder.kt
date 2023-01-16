package com.castor.threecommas.test_di.feature.login.di

import androidx.fragment.app.Fragment
import com.castor.threecommas.test_di.core.di.ComponentHolder
import com.castor.threecommas.test_di.feature.login.LoginFragment
import com.castor.threecommas.test_di.feature.login.name.LoginNameFragment
import com.castor.threecommas.test_di.feature.login.password.LoginPasswordFragment
import dagger.hilt.android.EntryPointAccessors

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
                    component = EntryPointAccessors.fromActivity(
                        fragment.requireActivity(),
                        LoginEntryPoint::class.java
                    )
                        .loginComponent(LoginModule())
//                        .childModule(LoginModule())
//                        .build()
                }
            }
        }
    }
}