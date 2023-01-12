import ApkConfig.BUILD_TOOLS_VERSION
import ApkConfig.COMPILE_SDK_VERSION
import ApkConfig.MIN_SDK_VERSION
import ApkConfig.TARGET_SDK_VERSION
import ApkConfig.JAVA_VERSION
import ApkConfig.VERSION_CODE
import ApkConfig.VERSION_NAME
import com.android.build.gradle.BaseExtension
import org.gradle.accessors.dm.LibrariesForLibs

val libs = the<LibrariesForLibs>()

configure<BaseExtension> {
    compileSdkVersion(COMPILE_SDK_VERSION)
    defaultConfig {
        minSdk = MIN_SDK_VERSION
        targetSdk = TARGET_SDK_VERSION
        buildToolsVersion = BUILD_TOOLS_VERSION

        versionCode = VERSION_CODE
        versionName = VERSION_NAME

        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        maybeCreate("debug").apply {
            isDebuggable = true
            isMinifyEnabled = false
        }

        maybeCreate("release").apply {
            isDebuggable = false
            isMinifyEnabled = true
            consumerProguardFile("proguard-rules.pro")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

    compileOptions {
        sourceCompatibility = JAVA_VERSION
        targetCompatibility = JAVA_VERSION
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}
