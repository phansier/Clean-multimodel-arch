plugins {
    id("android-library-convention")
    id("kotlin-kapt-convention")
}

dependencies {
    implementation(projects.moduleInjector)

    implementation(libs.androidx.appcompat)
    implementation(libs.dagger)
}

android {
    namespace = "com.example.core_db_api"
}
