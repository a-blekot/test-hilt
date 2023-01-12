pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    includeBuild("build-logic")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(
    ":app",
    ":core:analytics:api",
    ":core:analytics:impl",
    ":core:utils",
    ":feature:dashboard:details",
)

rootProject.name = "test-di"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")