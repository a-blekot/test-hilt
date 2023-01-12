plugins {
    id("android-library-convention")
}

android {
    namespace = "com.castor.threecommas.test_di.core.utils"
}

dependencies {
    implementation(projects.core.analytics.api)
}
