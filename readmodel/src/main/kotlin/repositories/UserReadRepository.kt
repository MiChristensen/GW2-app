package repositories

import data.User
import id.UserId

interface UserReadRepository: MinimalEntityRepository<UserId, User> {

}

interface AddonUserReadRepository {
    fun findByApiKey(apiKey: String): User?
}