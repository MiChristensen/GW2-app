@file:OptIn(KtorExperimentalLocationsAPI::class)

package gw2.locations

import gw2.ContentFactory
import gw2.models.frontPageModel
import gw2.models.getUserApiKeyModel
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*
import pages.FrontpageTemplate

sealed class RequestHandler<T : WebLocation> {
    abstract suspend fun PipelineContext<Unit, ApplicationCall>.handle(
        location: T
    )

    class NotFoundRequestHandler<T: WebLocation> : RequestHandler<T>() {
        override suspend fun PipelineContext<Unit, ApplicationCall>.handle(location: T) {
            call.respondText(status = HttpStatusCode.NotFound) { "notFound" }
        }
    }

    class FrontPageRequestHandler(
        contentFactory: ContentFactory
    ) : RequestHandler<WebLocation.FrontPageLocation>() {
        val model = contentFactory.frontPageModel()

        override suspend fun PipelineContext<Unit, ApplicationCall>.handle(
            location: WebLocation.FrontPageLocation
        ) {
            val response = model()

            call.respondHtmlTemplate(FrontpageTemplate(response)) {

            }
        }
    }

    class GetApiKeyRequestHandler(
        contentFactory: ContentFactory,
    ) : RequestHandler<WebLocation.GetApiKeyLocation>() {
        private val model = contentFactory.getUserApiKeyModel()
        override suspend fun PipelineContext<Unit, ApplicationCall>.handle(
            location: WebLocation.GetApiKeyLocation
        ) {
            val response = model(location.userId) ?: return notFound(location)
            okText(response)
        }
    }
}

private suspend fun <T : WebLocation> PipelineContext<Unit, ApplicationCall>.notFound(
    location: T
) = with(RequestHandler.NotFoundRequestHandler<T>()) {
    handle(location)
}

private suspend fun PipelineContext<Unit, ApplicationCall>.okText(text: String) {
    call.respondText(status = HttpStatusCode.OK) { text }
}

sealed interface WebLocation {
    @Location("/")
    data object FrontPageLocation : WebLocation

    @Location("/getApiKey")
    data class GetApiKeyLocation(
        val userId: Int,
    ) : WebLocation
}


enum class
HttpMethod {
    GET, POST;
}

// internal val allRequestHandlers = listOf(
//     RequestHandler.FrontPageHandler(),
//     RequestHandler.GetApiKeyHandler()
// )
//
// sealed interface RequestHandler<T : WebLocation> {
//     val method: HttpMethod
//     fun handle(webLocation: T)
//     class FrontPageHandler : RequestHandler<WebLocation.FrontPageLocation> {
//         override val method = HttpMethod.GET
//         override fun handle(webLocation: WebLocation.FrontPageLocation) {
//             TODO()
//         }
//     }
//
//     class GetApiKeyHandler : RequestHandler<WebLocation.GetApiKeyLocation> {
//         override val method = HttpMethod.GET
//         override fun handle(webLocation: WebLocation.GetApiKeyLocation) {
//             TODO()
//         }
//     }
//
// }