plugins {
    id("android-library-convention")
}

dependencies {
    implementation(projects.moduleInjector)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
}
android {
    namespace = "com.example.purchase_api"
}
