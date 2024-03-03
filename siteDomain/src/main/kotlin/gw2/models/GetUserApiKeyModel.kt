package gw2.models

import gw2.ContentFactory
import id.UserId
import repositories.UserReadRepository
import repositories.getByIdOrNull

fun ContentFactory.getUserApiKeyModel() = GetUserApiKeyModel(
    rmr.userReadRepository
)

class GetUserApiKeyModel(
    private val userRepo: UserReadRepository
) {
    operator fun invoke(rawUserId: Int): String? {
        // TODO IdFactory
        val userId = UserId.dontUseThisDirectly(rawUserId)
        val user = userRepo.getByIdOrNull(userId) ?: return null
        return user.apiKey
    }
}