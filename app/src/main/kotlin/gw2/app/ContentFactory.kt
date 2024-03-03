package gw2.app

import gw2.ContentFactory
import org.jetbrains.exposed.sql.Database
import repositories.RepositoriesWrapper

class ContentFactoryImpl(
    private val db: Database
): ContentFactory {
    private val repoWrapper: RepositoriesWrapper
        get() = repositories.repositories(db)

    override val rmr = repoWrapper.readModelRepositories
    override val wmr = repoWrapper.writeModelRepositories
}