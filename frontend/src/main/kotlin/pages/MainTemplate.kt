package pages

import io.ktor.server.html.*
import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.script

interface GW2Template {
    fun HTML.html()
}

class MainPageTemplate(
    private val template: GW2Template
) : Template<HTML> {
    override fun HTML.apply() {
        head {
            link(rel = "stylesheet", href = "styles/everything.css", type = "text/css") { }
            script(src="https://unpkg.com/hyperscript.org@0.9.12") { }
        }
        with(template) {
            html()
        }
    }
}
