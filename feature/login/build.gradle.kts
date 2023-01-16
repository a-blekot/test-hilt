plugins {
    id("android-library-convention")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
    namespace = "com.castor.threecommas.test_di.feature.login"
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(projects.core.analytics.api)
    implementation(projects.core.di)
    implementation(projects.core.utils)

    implementation(libs.bundles.app)
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
}