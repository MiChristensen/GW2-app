package extensions

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction

fun <T> Database.transaction(statement: Transaction.() -> T): T = transaction(db = this, statement = statement)