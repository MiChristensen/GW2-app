package gw2

import gw2.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.locations.*
import io.ktor.server.netty.*


fun serveRoutes(contentFactory: ContentFactory) {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = { module(contentFactory) })
        .start(wait = true)
}

@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.module(contentFactory: ContentFactory) {
    install(Locations)
    configureRouting(contentFactory)
}
