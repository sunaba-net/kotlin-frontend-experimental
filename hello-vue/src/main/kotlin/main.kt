import vue.Vue
import vue.VueComponent
import vue.register
import kotlin.browser.document
import kotlin.browser.window

class ButtonCounter : VueComponent<ButtonCounter.CountModel>({
    template = """
        <button v-on:click="${ButtonCounter::onClick}">
            You clicked me {{ count }} times.
        </button>
    """
    data = { CountModel() }
}) {
    class CountModel(var count: Int = 0)

    fun onClick() {
        data.count += 1
    }
}

fun main() {

    document.getElementById("vue-container")?.innerHTML = """
        <div id="components-demo">
        <button-counter></button-counter>
        </div>
    """

    ButtonCounter().register("button-counter")

    Vue(object {
        val el = "#components-demo"
    })
}