plugins {
    id("android-library-convention")
}

android {
    namespace = "com.castor.threecommas.test_di.core.di"
}

dependencies {
    implementation(libs.bundles.app)
}