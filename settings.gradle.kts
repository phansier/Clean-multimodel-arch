enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "Clean-multimodel-arch"

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
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}