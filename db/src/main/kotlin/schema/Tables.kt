package schema

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

class Tables {
    object Users: Table("users") {
        val user_id: Column<Int> = integer("user_id").autoIncrement()
        val api_key: Column<String> = varchar("api_key", 100)

        override val primaryKey = PrimaryKey(user_id)
    }
}