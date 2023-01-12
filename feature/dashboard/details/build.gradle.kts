plugins {
    id("android-library-convention")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.castor.threecommas.test_di.feature.dashboard.details"
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
}