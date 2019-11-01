group = "net.sunaba.kotlin.frontend.experimental"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("js") version "1.3.50" apply false
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.js")
    }
}