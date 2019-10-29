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

        }
    }
    sourceSets["main"].dependencies {
//        implementation(npm("left-pad"))
//        implementation()
        implementation(npm("firebase"))
        implementation(npm("firebaseui"))

        implementation(npm("vue"))

    }
}