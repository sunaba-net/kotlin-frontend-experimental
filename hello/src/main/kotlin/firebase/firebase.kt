@file:JsModule("firebase")

package firebase

import firebase.app.App
import firebase.auth.Auth

external fun initializeApp(obj: FirebaseOptions, name: String = definedExternally): App
external val apps: Array<App>
external val SDK_VERSION: String

external fun auth(): Auth

