package gw2.sharedUtil.gw2.sharedUtil

import gw2.sharedUtil.equalsIgnoringOrder
import kotlin.test.Test
import kotlin.test.assertTrue

class Misc {
    @Test
    fun `equalsIgnoringOrder works`() {
        assertEqualsIgnoringOrder(listOf(1, 2, 2, 3), listOf(3, 1, 2, 2))
        assertEqualsIgnoringOrder(listOf(1, 2, 3, 4), listOf(1, 2, 3, 4))
    }
}

fun<T> assertEqualsIgnoringOrder(
    expected: List<T>,
    actual: List<T>,
    msg: String? = null
) {
    assertTrue(msg) { expected.equalsIgnoringOrder(actual) }
}
