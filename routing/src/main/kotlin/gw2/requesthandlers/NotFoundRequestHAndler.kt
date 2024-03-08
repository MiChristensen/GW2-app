package gw2.requesthandlers

import gw2.locations.WebLocation
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

class NotFoundRequestHandler<T: WebLocation> : RequestHandler<T>() {
    override suspend fun PipelineContext<Unit, ApplicationCall>.handle(location: T) {
        call.respondText(status = HttpStatusCode.NotFound) { "notFound" }
    }
}
suspend fun <T : WebLocation> PipelineContext<Unit, ApplicationCall>.notFound(
    location: T
) = with(NotFoundRequestHandler<T>()) {
    handle(location)
}