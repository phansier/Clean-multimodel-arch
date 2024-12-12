plugins {
    id("android-application-convention")
    id("kotlin-kapt-convention")
    id("android-compose-convention")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    defaultConfig {
        applicationId = "com.example.eugene_matsyuk.dagger_arch"
    }
    namespace = "com.example.eugene_matsyuk.dagger_arch"
}

dependencies {
    implementation(projects.moduleInjector)

    implementation(projects.coreUtils)
    implementation(projects.coreDb)
    implementation(projects.coreNetwork)

    implementation(projects.featureScanner)
    implementation(projects.featureAntitheft)
    implementation(projects.featurePurchaseImpl)
    implementation(projects.featurePurchaseApi)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraint)
    implementation(libs.material)

    implementation(libs.navigation)
    implementation(libs.kotlin.serialization.json)

    implementation(libs.dagger)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
}
