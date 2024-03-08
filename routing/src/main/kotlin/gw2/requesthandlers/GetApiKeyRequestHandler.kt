package gw2.requesthandlers

import gw2.ContentFactory
import gw2.locations.WebLocation
import gw2.models.getUserApiKeyModel
import io.ktor.server.application.*
import io.ktor.util.pipeline.*
import pages.GetApiKeyTemplate

class GetApiKeyRequestHandler(
    contentFactory: ContentFactory,
) : RequestHandler<WebLocation.GetApiKeyLocation>() {
    private val model = contentFactory.getUserApiKeyModel()
    override suspend fun PipelineContext<Unit, ApplicationCall>.handle(
        location: WebLocation.GetApiKeyLocation
    ) {
        val response = model(location.userId) ?: return notFound(location)
        pageTemplate(GetApiKeyTemplate(response))
    }
}
