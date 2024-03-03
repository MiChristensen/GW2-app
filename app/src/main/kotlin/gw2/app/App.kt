package gw2.app

import connectToDatabase
import gw2.serveRoutes
import id.UserId
import org.jetbrains.exposed.sql.Database
import repositories.RepositoriesWrapper
import repositories.getByIdOrNull

fun main() {
    val db = db()
    val repositories = repositories(db)
    serveRoutes()
    println(repositories.readModelRepositories.userReadRepository.getByIdOrNull(UserId.dontUseThisDirectly(1)))
}

private fun db(): Database {
    return connectToDatabase()
}
private fun repositories(db: Database): RepositoriesWrapper {
    return repositories.repositories(db)
}
