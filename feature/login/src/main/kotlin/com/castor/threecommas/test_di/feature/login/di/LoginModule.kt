package com.castor.threecommas.test_di.feature.login.di

import com.castor.threecommas.test_di.core.di.FeatureScope
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Inject

@[Module DisableInstallInCheck]
class LoginModule {
    @[Provides FeatureScope]
    fun provideTestInterface(): LoginModuleInterface =
        LoginModuleImpl()
}

class LoginModuleImpl @Inject constructor() : LoginModuleInterface {
    override val msg: String = "LoginModuleImpl"
}

interface LoginModuleInterface {
    val msg: String
}
