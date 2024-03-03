package gw2

import gw2.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.locations.*
import io.ktor.server.netty.*


fun serveRoutes() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.module() {
    install(Locations)
    configureRouting()
}
