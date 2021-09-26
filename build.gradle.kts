allprojects {
    val minSdkVersion by extra(21)
    val compileSdkVersion by extra(30)
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
