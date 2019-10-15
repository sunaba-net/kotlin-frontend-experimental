import kotlinx.html.*
import kotlinx.html.stream.createHTML
import vue.Vue
import kotlin.reflect.KProperty

class VueComponentOptions<T> {

    var _template: String = ""
    var methods: dynamic.() -> Any = {}

    fun template(builder: TagConsumer<String>.() -> Unit) {
        this._template = createHTML().apply(builder).finalize()
        println(_template)
    }

    lateinit var data: (() -> T)

    fun methods(block: dynamic.() -> Any) {
        this.methods = block
    }

    fun toObject(): Any = object {
        val data: () -> T = this@VueComponentOptions.data
        val template = _template
        val methods = ButtonCounter()
    }
}

open class VueComponent<T : Any>(val builder: VueComponentOptions<T>.() -> Unit) {

    inline val data: T
        get() = js("this.\$data") as T

    fun toVueJs(): Any = VueComponentOptions<T>().apply(builder).toObject()
}

class VueAttribute(private val attributeName: String) {
    operator fun getValue(thisRef: HTMLTag, property: KProperty<*>): String {
        return thisRef.attributes[attributeName] ?: ""
    }

    operator fun setValue(thisRef: HTMLTag, property: KProperty<*>, value: String) {
        thisRef.attributes[attributeName] = value ?: ""
    }
}

var HTMLTag.vOnClick by VueAttribute("v-on:click")

class CountModel {
    var count: Int = 0
}

class ButtonCounter : VueComponent<CountModel>({
    template {
        button {
            vOnClick = ButtonCounter::onClick.name
            +"You clicked me {{ count }} times."
        }
    }
    data = { CountModel() }
}) {
    fun onClick() {
        data.count++
    }
}

fun main() {
    Vue.component("button-counter", ButtonCounter().toVueJs())
    Vue(object {
        val el = "#components-demo"
    })
}