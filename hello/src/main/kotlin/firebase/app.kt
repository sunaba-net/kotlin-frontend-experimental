@file:JsModule("firebase")
package firebase.app

import firebase.FirebaseOptions
import firebase.auth.Auth

external class App {
    val name:String
    val options:FirebaseOptions

    fun auth():Auth
}
