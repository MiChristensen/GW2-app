package gw2.plugins

import gw2.ContentFactory
import gw2.locations.WebLocation
import gw2.requesthandlers.FrontPageRequestHandler
import gw2.requesthandlers.GetApiKeyRequestHandler
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.locations.*
import io.ktor.server.routing.*


@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.configureRouting(contentFactory: ContentFactory) {
    routing {
        get<WebLocation.FrontPageLocation> {location ->
            val requestHandler = FrontPageRequestHandler(contentFactory)
            with(requestHandler) {
                handle(location)
            }
        }

        get<WebLocation.GetApiKeyLocation> { location ->
            with(GetApiKeyRequestHandler(contentFactory)) {
                handle(location)
            }
        }
        staticResources("/styles", "css")
    }
}
