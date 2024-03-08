@file:OptIn(KtorExperimentalLocationsAPI::class)

package gw2.locations

import io.ktor.server.locations.*


sealed interface WebLocation {
    @Location("/")
    data object FrontPageLocation : WebLocation

    @Location("/getApiKey")
    data class GetApiKeyLocation(
        val userId: Int,
    ) : WebLocation
}
