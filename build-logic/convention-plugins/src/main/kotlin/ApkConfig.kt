import org.gradle.api.JavaVersion

object ApkConfig {
    const val APPLICATION_ID = "com.castor.threecommas.test_di"
    const val APPLICATION_ID_SUFFIX = ".dev"

    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 33
    const val COMPILE_SDK_VERSION = 33
    const val BUILD_TOOLS_VERSION = "33.0.0"

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    val JAVA_VERSION = JavaVersion.VERSION_1_8
    val JAVA_VERSION_NAME = JavaVersion.VERSION_1_8.toString()
}