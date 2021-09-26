import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

plugins {
    id("kotlin-kapt")
}

project.withVersionCatalog { libs ->

    dependencies {
        //add(Configurations.kapt, platform(libs.kotlinBom))

        add("kapt", libs.daggerCompiler)
        add("kapt", libs.moxyCompiler)
    }
}

/**
 * workaround to make version catalog accessible in convention plugins
 * https://github.com/gradle/gradle/issues/15383
 */
fun Project.withVersionCatalog(block: (libs: LibrariesForLibs) -> Unit) {
    val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()
    block.invoke(libs)
}