import ru.beryukhov.android.withVersionCatalog

plugins {
    id("org.jetbrains.kotlin.plugin.compose")
}

// workaround for https://github.com/gradle/gradle/issues/15383
project.withVersionCatalog { libs ->
    dependencies {
        add("implementation", libs.compose.ui)
        add("implementation", libs.compose.material3)

        add("debugImplementation", libs.compose.uiTooling)

        add("implementation", libs.compose.preview)
    }

}