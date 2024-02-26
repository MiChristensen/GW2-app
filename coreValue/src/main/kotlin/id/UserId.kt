package id

@Suppress("DataClassPrivateConstructor")
data class UserId private constructor(
    val id: Int
) {
    companion object {
        fun dontUseThisDirectly(id: Int) = UserId(id)
    }
}