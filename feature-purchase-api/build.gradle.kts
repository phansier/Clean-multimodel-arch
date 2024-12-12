plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projects.moduleInjector)

    implementation(libs.rxJava)
    implementation(libs.rxAndroid)
}
android {
    namespace = "com.example.purchase_api"
}
