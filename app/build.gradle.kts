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
    implementation(projects.feature.dashboard.details)
    implementation(projects.feature.login)

    implementation(libs.bundles.app)
    implementation(libs.dagger.hilt.android)
//    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.navigation.fragment)

    kapt(libs.dagger.hilt.compiler)
//    kapt(libs.hilt.compiler)

//    hilt-compiler = { module = "androidx.hilt:hilt-compile", version.ref = "hilt" }
//    hilt-navigation-compose = { module = "androidx.hilt:hilt-navigation-compose", version.ref = "hilt" }
//    hilt-navigation-fragment = { module = "androidx.hilt:hilt-navigation-fragment", version.ref = "hilt" }
//    hilt-work = { module = "androidx.hilt:hilt-work", version.ref = "hilt" }
}