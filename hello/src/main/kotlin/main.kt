import firebase.FirebaseOptions
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.p
import kotlin.browser.document


fun main() {
    val myDiv = document.create.div {
        p {
            +"Hello kotlinx html"
        }
    }
    document.getElementById("myDiv")!!.appendChild(myDiv)


    var firebaseConfig = FirebaseOptions(
            apiKey = "AIzaSyC77D9hMJXhzHsiCSVZXSMJZP4wl7fTE2w",
            authDomain = "zundaretestapp.firebaseapp.com",
            databaseURL = "https://zundaretestapp.firebaseio.com",
            projectId = "zundaretestapp",
            storageBucket = "zundaretestapp.appspot.com",
            messagingSenderId = "316705654045",
            appId = "1:316705654045:web:65889fd0ee84b3da1a0df4"
    )
    val app = firebase.initializeApp(firebaseConfig)
    document.write("Hello Firebase")


}