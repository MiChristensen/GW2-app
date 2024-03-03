@file:OptIn(KtorExperimentalLocationsAPI::class)

package gw2.locations

import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

sealed interface RequestHandler<T : WebLocation> {
    suspend fun handle(
        pipelineContext: PipelineContext<Unit, ApplicationCall>,
        location: T
    )

    data object FrontPageRequestHandler : RequestHandler<WebLocation.FrontPageLocation> {
        override suspend fun handle(
            pipelineContext: PipelineContext<Unit, ApplicationCall>,
            location: WebLocation.FrontPageLocation
        ) {
            pipelineContext.call.respondText {
                "frontPage"
            }
        }
    }

    data object GetApiKeyRequestHandler : RequestHandler<WebLocation.GetApiKeyLocation> {
        override suspend fun handle(
            pipelineContext: PipelineContext<Unit, ApplicationCall>,
            location: WebLocation.GetApiKeyLocation
        ) {
            pipelineContext.call.respondText {
                "getApiKey: ${location.userId}"
            }
        }
    }
}

sealed interface WebLocation {
    @Location("/")
    data object FrontPageLocation : WebLocation

    @Location("/getApiKey")
    data class GetApiKeyLocation(
        val userId: String,
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