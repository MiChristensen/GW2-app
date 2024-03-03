package pages

import io.ktor.server.html.*
import kotlinx.html.*
import templateData.FrontpageTemplateData

interface GW2Template : Template<FlowContent> {
    fun FlowContent.apply(data: FrontpageTemplateData)
    override fun FlowContent.apply(): Unit {
        apply()
    }
}

class FrontpageTemplate(
    private val templateData: FrontpageTemplateData
) : Template<HTML> {
    override fun HTML.apply() {
        body {
            div {
                h1 {
                    +templateData.title
                }
                p {
                    +templateData.content
                }
            }
        }
    }
}