pluginManagement.repositories {
    gradlePluginPortal()
    maven {
        name = "Fabric"
        url = uri("https://maven.fabricmc.net/")
    }
    maven {
        name = "Sponge Snapshots"
        url = uri("https://repo.spongepowered.org/repository/maven-public/")
    }
}

rootProject.name = "BYG"
include("Common", "Fabric", "Forge")