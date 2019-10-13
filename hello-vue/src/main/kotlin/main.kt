import vue.Vue

fun main() {
    Vue.component("button-counter", object {
        fun data(): Any {
            return object {
                val count = 0
            }
        }

        val template = """
            <button v-on:click="count++">You clicked me {{ count }} times.</button>
        """.trimIndent()
    })

    Vue(object {
        val el = "#components-demo"
    })

}