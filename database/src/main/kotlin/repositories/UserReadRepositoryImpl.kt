package repositories

import data.User
import extensions.transaction
import id.UserId
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import schema.Tables

class UserReadRepositoryImpl(
    private val db: Database
): UserReadRepository {
    override fun findByApiKey(apiKey: String): User? = db.transaction {
        Tables.Users
            .slice(
                Tables.Users.user_id,
                Tables.Users.api_key,
            )
            .select {
                Tables.Users.api_key eq apiKey
            }
            .map {
                User(
                    UserId.dontUseThisDirectly(it[Tables.Users.user_id]),
                    it[Tables.Users.api_key]
                )
            }
            .firstOrNull()
    }
    override fun getByIdsOrAbsent(ids: Collection<UserId>): Map<UserId, User> = db.transaction {
        Tables.Users
            .slice(
                Tables.Users.user_id,
                Tables.Users.api_key,
            )
            .select {
                Tables.Users.user_id inList ids.map { it.id }
            }
            .map {
                User(
                    UserId.dontUseThisDirectly(it[Tables.Users.user_id]),
                    it[Tables.Users.api_key]
                )
            }
            .associateBy { it.userId }
    }
}