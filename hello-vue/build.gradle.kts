plugins {
    id("org.jetbrains.kotlin.js") version "1.3.50"
}

group = "net.sunaba.kotlin.frontend.experimental"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
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