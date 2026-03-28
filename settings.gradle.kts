pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://repo.spring.io/plugins-release") }
    }
}

rootProject.name = "VETRO NEXUS"

include("subproject1")
include("subproject2")
