package com.castor.threecommas.test_di.feature.login.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@[EntryPoint InstallIn(ActivityComponent::class)]
interface LoginEntryPoint {
    fun loginComponent(module: LoginModule): LoginComponent
}