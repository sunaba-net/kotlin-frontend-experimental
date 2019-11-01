group = "net.sunaba.kotlin.frontend.experimental"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
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
            }
            webpackTask {
                sourceMaps = false
                archiveFileName = "app.js"
            }
        }
    }
//    sourceSets["main"].dependencies {
//    }
}