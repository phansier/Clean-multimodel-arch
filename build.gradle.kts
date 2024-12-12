allprojects {
    val minSdkVersion by extra(21)
    val compileSdkVersion by extra(30)
}

buildscript {
    repositories {
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.androidGradle)
        classpath(libs.kotlinGradle)
        classpath(libs.kaptGradle)
    }
}
