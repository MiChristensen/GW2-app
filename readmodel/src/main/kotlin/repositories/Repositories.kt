package repositories

class RepositoriesWrapper(
    val readModelRepositories: ReadModelRepositories,
    val writeModelRepositories: WriteModelRepositories
)

class ReadModelRepositories(
    val userReadRepository: UserReadRepository
)

class WriteModelRepositories(

)