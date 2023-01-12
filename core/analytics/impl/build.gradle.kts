plugins {
    id("android-library-convention")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.castor.threecommas.test_di.core.analytics.impl"
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    api(projects.core.analytics.api)

    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
}
