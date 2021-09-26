plugins {
    id("android-application-convention")
    id("kotlin-kapt-convention")
}

android {
    defaultConfig {
        applicationId = "com.example.eugene_matsyuk.dagger_arch"

    }
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

    implementation(libs.cicerone)

    implementation(libs.dagger)

    implementation(libs.moxy)
    implementation(libs.moxyAndroid)

    implementation(libs.rxJava)
    implementation(libs.rxAndroid)
}
