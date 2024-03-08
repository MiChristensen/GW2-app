package gw2.requesthandlers

import gw2.locations.WebLocation
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.util.pipeline.*
import pages.GW2Template
import pages.MainPageTemplate

sealed class RequestHandler<T : WebLocation> {
    abstract suspend fun PipelineContext<Unit, ApplicationCall>.handle(
        location: T
    )
}

internal suspend fun PipelineContext<Unit, ApplicationCall>.pageTemplate(gw2Template: GW2Template) {
    call.respondHtmlTemplate(MainPageTemplate(gw2Template), status = HttpStatusCode.OK) { }
}