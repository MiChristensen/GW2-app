package repositories

interface MinimalEntityRepository<Id, Entity> {
    fun getByIdsOrAbsent(ids: Collection<Id>): Map<Id, Entity>
}

fun <Id, Entity> MinimalEntityRepository<Id, Entity>.getByIdOrNull(id: Id): Entity? {
    return getByIdsOrAbsent(listOf(id))[id]
}