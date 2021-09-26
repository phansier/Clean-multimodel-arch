
buildscript {
    val kotlin_version by extra("1.5.30")
    val moxy_version by extra("2.2.2")
    val dagger_version by extra("2.38.1")
    val rxJava_version by extra("2.2.19")
    val rxAndroid_version by extra("2.1.1")
    val cicerone_version by extra("7.1")
    val appcompat_version by extra("1.3.1")
    val constraint_version by extra("2.1.0")
}

allprojects {
    val minSdkVersion by extra(21)
    val compileSdkVersion by extra(30)
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
