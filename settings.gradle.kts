enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

includeBuild("build-logic")

include(":app")
include(":feature-scanner")
include(":feature-antitheft")
include(":feature-scanner-example")
include(":feature-purchase-api")
include(":feature-purchase-impl")
include(":core-network")
include(":core-db")
include(":core-utils")
include(":module-injector")

pluginManagement {

    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")//for kapt plugin 1.5.30
    }
}

dependencyResolutionManagement {

    repositories {
        google()
        mavenCentral()
    }
}