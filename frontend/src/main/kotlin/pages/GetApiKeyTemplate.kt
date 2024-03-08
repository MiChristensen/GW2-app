package pages

import extensions.`_`
import kotlinx.html.HTML
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.p
import templateData.GetApiKeyTemplateData

class GetApiKeyTemplate(
    private val data: GetApiKeyTemplateData
) : GW2Template {
    override fun HTML.html() {
        body {
            h1 { +"Get API Key" }
            p("red-bg bordered") {
                `_` = """
                    on click
                        toggle .red-bg
                    end
                """.trimIndent()
                +"API Key of user: ${data.userId} is: ${data.apiKey}"
            }
        }
    }
}