plugins {
    id("android-library-convention")
    id("kotlin-kapt-convention")
    id("android-compose-convention")
    id("org.jetbrains.kotlin.plugin.serialization")
}

dependencies {
    implementation(projects.moduleInjector)

    implementation(projects.coreUtils)
    implementation(projects.coreDb)
    implementation(projects.coreNetwork)

    implementation(projects.featurePurchaseApi)

    implementation(libs.androidx.appcompat)
    implementation(libs.dagger)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    implementation(libs.moxy)
    implementation(libs.moxyAndroid)
    implementation(libs.moxyKtx)

    implementation(libs.navigation)
    implementation(libs.kotlin.serialization.json)
}

android {
    namespace = "com.example.scanner_api"

}