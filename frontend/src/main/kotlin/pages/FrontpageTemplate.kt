package pages

import kotlinx.html.*
import templateData.FrontpageTemplateData


class FrontpageTemplate(
    private val templateData: FrontpageTemplateData
) : GW2Template {
    override fun HTML.html() {
        body {
            div("red-bg bordered") {
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