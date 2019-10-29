

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
            }
            webpackTask {
                sourceMaps = false
                archiveFileName = "app.js"
            }
        }
    }
    sourceSets["main"].dependencies {
        implementation(npm("vue"))
        implementation(npm("google-protobuf"))
    }
}