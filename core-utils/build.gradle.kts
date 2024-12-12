plugins {
    id("android-library-convention")
    id("kotlin-kapt-convention")
}

dependencies {
    implementation(projects.moduleInjector)

    implementation(libs.androidx.appcompat)
    implementation(libs.dagger)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
}

android {
    namespace = "com.example.core"
}
