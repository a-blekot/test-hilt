import ApkConfig.APPLICATION_ID

plugins {
    kotlin("android")
    id("com.android.application")
    id("kotlin-base-convention")
    id("android-base-convention")
}

android {
    defaultConfig {
        applicationId = APPLICATION_ID
    }

    buildFeatures {
        viewBinding = true
    }
}
