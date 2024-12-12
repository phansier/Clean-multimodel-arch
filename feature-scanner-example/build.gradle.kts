plugins {
    id("android-application-convention")
    id("kotlin-kapt-convention")
}

dependencies {
    implementation(projects.moduleInjector)

    implementation(projects.coreUtils)
    implementation(projects.coreDb)
    implementation(projects.coreNetwork)

    implementation(projects.featureScanner)
    implementation(projects.featurePurchaseApi)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraint)

    implementation(libs.material)

    implementation(libs.rxJava)
    implementation(libs.rxAndroid)

    implementation(libs.dagger)

    implementation(libs.moxy)
    implementation(libs.moxyAndroid)
}

android {
    namespace = "com.example.scanner_example"
}