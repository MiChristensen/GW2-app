package gw2.sharedUtil

fun<T> List<T>.equalsIgnoringOrder(other: List<T>): Boolean {
    if (this.size != other.size) return false
    fun List<T>.groupToCount() = groupBy { it }
        .mapValues { (_, values) -> values.count() }

    return groupToCount() == other.groupToCount()
}