plugins {
    id("android-library-convention")
    id("kotlin-kapt-convention")
}

dependencies {
    implementation(projects.moduleInjector)

    implementation(projects.coreUtils)
    implementation(projects.coreDb)
    implementation(projects.coreNetwork)

    implementation(projects.featurePurchaseApi)

    implementation(libs.androidx.appcompat)
    implementation(libs.dagger)

    implementation(libs.rxJava)
    implementation(libs.rxAndroid)

    implementation(libs.moxy)
    implementation(libs.moxyAndroid)

    implementation(libs.cicerone)
}

android {
    namespace = "com.example.scanner_api"

}