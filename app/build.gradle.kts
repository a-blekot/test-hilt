plugins {
    id("android-application-convention")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.castor.threecommas.test_di"
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(projects.core.utils)
    implementation(projects.core.analytics.impl)
    implementation(projects.feature.login)

    implementation(libs.bundles.app)

    // Hilt DI
    implementation(libs.dagger.hilt.android)
    implementation(libs.hilt.navigation.fragment)
    kapt(libs.dagger.hilt.compiler)
}