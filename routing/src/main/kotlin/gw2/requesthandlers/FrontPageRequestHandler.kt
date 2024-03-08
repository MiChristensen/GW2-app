package gw2.requesthandlers

import gw2.ContentFactory
import gw2.locations.WebLocation
import gw2.models.frontPageModel
import io.ktor.server.application.*
import io.ktor.util.pipeline.*
import pages.FrontpageTemplate

class FrontPageRequestHandler(
    contentFactory: ContentFactory
) : RequestHandler<WebLocation.FrontPageLocation>() {
    val model = contentFactory.frontPageModel()

    override suspend fun PipelineContext<Unit, ApplicationCall>.handle(
        location: WebLocation.FrontPageLocation
    ) {
        pageTemplate(FrontpageTemplate(model()))
    }
}