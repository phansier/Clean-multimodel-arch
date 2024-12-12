import ru.beryukhov.android.withVersionCatalog

plugins {
    id("kotlin-kapt")
}

// workaround for https://github.com/gradle/gradle/issues/15383
project.withVersionCatalog { libs ->
    dependencies {
        add("kapt", libs.daggerCompiler)
        add("kapt", libs.moxyCompiler)
    }
}
