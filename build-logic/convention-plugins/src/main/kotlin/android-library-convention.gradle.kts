plugins {
    kotlin("android")
    id("com.android.library")
    id("kotlin-base-convention")
    id("android-base-convention")
}

android {
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("javax.inject:javax.inject:1")
}