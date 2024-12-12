plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(projects.gradleExt)
    implementation(libs.androidGradle)
    implementation(libs.kotlinGradle)
    implementation(libs.kaptGradle)
    implementation(libs.composeKotlinGradle)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

