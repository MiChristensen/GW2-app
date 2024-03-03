package gw2.models

import gw2.ContentFactory
import templateData.FrontpageTemplateData


fun ContentFactory.frontPageModel() = FrontpageModel(

)
class FrontpageModel(

) {
    operator fun invoke(): FrontpageTemplateData {
        return FrontpageTemplateData(
            title = "this is the mf frontpage title",
            content = "this is the mf frontpage content",
        )
    }
}