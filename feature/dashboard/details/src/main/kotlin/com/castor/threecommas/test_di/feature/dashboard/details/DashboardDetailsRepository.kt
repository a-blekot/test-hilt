package com.castor.threecommas.test_di.feature.dashboard.details

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Scope


@ViewModelScoped
class DashboardDetailsRepository @Inject constructor() {

    private val timeCreated = System.currentTimeMillis()

    val text: String
        get() = "DashboardDetailsRepository (timeCreated=$timeCreated): $this"
}

//@InstallIn(DashboardDetailsComponent::class)
//@Module
//object UserModule {
//    @DashboardDetailsScoped
//    @Provides
//    fun provideUserScopedBinding() = Any()
//}


@Qualifier
annotation class DashboardDetailsId

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class DashboardDetailsScoped

@DashboardDetailsScoped
@DefineComponent(parent = ViewModelComponent::class)
interface DashboardDetailsComponent

@DefineComponent.Builder
interface DashboardDetailsComponentBuilder {
    fun dashboardDetailsId(@BindsInstance @DashboardDetailsId id: String): DashboardDetailsComponentBuilder
    fun build(): DashboardDetailsComponent
}


@EntryPoint
@InstallIn(DashboardDetailsComponent::class)
interface DashboardDetailsEntryPoint {
}

class DashboardDetailsComponentManager @Inject constructor(
    private val componentBuilder: DashboardDetailsComponentBuilder
) {

    fun doSomething() {
        val component = componentBuilder.build();
        EntryPoints.get(component, DashboardDetailsEntryPoint::class.java)


    }
}