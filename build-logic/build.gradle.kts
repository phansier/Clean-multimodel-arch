plugins {
    `kotlin-dsl`
}

dependencies {

    /**
     * workaround to make version catalog accessible in convention plugins
     * https://github.com/gradle/gradle/issues/15383
     */
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(libs.androidGradle)
    implementation(libs.kotlinGradle)
}