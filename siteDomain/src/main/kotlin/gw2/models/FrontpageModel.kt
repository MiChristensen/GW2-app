package gw2.models

import gw2.ContentFactory


fun ContentFactory.frontPageModel() = FrontpageModel(

)
class FrontpageModel(

) {
    operator fun invoke(): String {
        return "this is the mf frontpage"
    }
}