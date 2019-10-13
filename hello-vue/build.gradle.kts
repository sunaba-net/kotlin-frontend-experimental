plugins {
    id("org.jetbrains.kotlin.js") version "1.3.50"
}

group = "net.sunaba.kotlin.frontend.experimental"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}


kotlin {
    target {
        useCommonJs()
        browser {
            runTask {
                archiveFileName = "app.js"
                println(configDirectory)
                println(configFile)
            }
        }
    }
    sourceSets["main"].dependencies {
        implementation(npm("vue"))
    }
}