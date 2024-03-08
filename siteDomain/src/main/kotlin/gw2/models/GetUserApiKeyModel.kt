package gw2.models

import gw2.ContentFactory
import id.UserId
import repositories.UserReadRepository
import repositories.getByIdOrNull
import templateData.GetApiKeyTemplateData

fun ContentFactory.getUserApiKeyModel() = GetUserApiKeyModel(
    rmr.userReadRepository
)

class GetUserApiKeyModel(
    private val userRepo: UserReadRepository
) {
    operator fun invoke(rawUserId: Int): GetApiKeyTemplateData? {
        // TODO IdFactory
        val userId = UserId.dontUseThisDirectly(rawUserId)
        val user = userRepo.getByIdOrNull(userId) ?: return null
        return GetApiKeyTemplateData(user.userId.id, user.apiKey)
    }
}