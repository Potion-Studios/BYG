pluginManagement.repositories {
    gradlePluginPortal()
    maven {
        name = "Fabric"
        url = uri("https://maven.fabricmc.net/")
    }
    maven {
        name = "Forge"
        url = uri("https://maven.minecraftforge.net/")
    }
    maven {
        name = "Sponge Snapshots"
        url = uri("https://repo.spongepowered.org/repository/maven-public/")
    }
    maven {
        name = "ParchmentMC"
        url = uri("https://maven.parchmentmc.org/")
    }
}

rootProject.name = "BYG"
include("Common", "Fabric", "Forge")