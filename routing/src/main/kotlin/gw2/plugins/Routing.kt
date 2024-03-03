package gw2.plugins

import gw2.ContentFactory
import gw2.locations.RequestHandler
import gw2.locations.WebLocation
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.routing.*


@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.configureRouting(contentFactory: ContentFactory) {
    routing {
        get<WebLocation.FrontPageLocation> {location ->
            val requestHandler = RequestHandler.FrontPageRequestHandler(contentFactory)
            with(requestHandler) {
                handle(location)
            }
        }

        get<WebLocation.GetApiKeyLocation> { location ->
            with(RequestHandler.GetApiKeyRequestHandler(contentFactory)) {
                handle(location)
            }
        }
    }
}



// @OptIn(KtorExperimentalLocationsAPI::class)
// fun Application.configureRouting() {
//     routing {
//         val allRequestHandlers = allRequestHandlers
//         allRequestHandlers.map { requestHandler ->
//             val location = requestHandler::class.typeParameters
//                 .firstNotNullOfOrNull { it::class as? WebLocation }
//                 ?: throw IllegalArgumentException("RequestHandler must have a location type parameter")
//
//             val path = location::class.findAnnotation<Location>()?.path
//                 ?: throw IllegalArgumentException("Location must have a @Location annotation")
//
//             when(requestHandler.method) {
//                 HttpMethod.GET -> {
//                     get(path) { location ->
//                         call.respondText {
//                             "this shit works"
//                         }
//                     }
//                 }
//                 HttpMethod.POST -> TODO()
//             }
//         }
//     }
// }
