package  vue

class VueComponentConfig<T>() {
    var template: String = ""
    lateinit var data: (() -> T)
}

open class VueComponent<T : Any>(val config: VueComponentConfig<T>.() -> Unit) {
    inline val data: T
        get() = js("this.\$data") as T
}

inline fun <reified T : Any> VueComponent<T>.register(name: String): Unit {
    Vue.component(name, toVueObject())
}

inline fun <reified T : Any> VueComponent<T>.toVueObject(): Any {
    val config = VueComponentConfig<T>().apply(config)
    return object {
        val data: () -> T = config.data
        val template = config.template
        val methods = this@toVueObject
    }
}