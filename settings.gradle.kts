pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        resolutionStrategy {
            eachPlugin {
                if (requested.id.id == "io.objectbox.plugin") {
                    useModule("io.objectbox:objectbox-gradle-plugin:${requested.version}")
                }
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.objectbox.io")
        maven("https://jitpack.io")
    }
}
rootProject.name = "PracticalTaskAndroid"
include(":app")
