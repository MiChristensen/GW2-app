package repositories

import org.jetbrains.exposed.sql.Database


fun repositories(database: Database): RepositoriesWrapper {
    return RepositoriesWrapper(
        readModelRepositories = readModelRepositories(database),
        writeModelRepositories = writeModelRepositories(database)
    )
}

private fun readModelRepositories(database: Database): ReadModelRepositories {
    return ReadModelRepositories(
        userReadRepository = UserReadRepositoryImpl(database)
    )
}
@Suppress("UNUSED_PARAMETER")
private fun writeModelRepositories(database: Database): WriteModelRepositories {
    return WriteModelRepositories(

    )
}