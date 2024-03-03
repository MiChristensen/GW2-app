import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.DatabaseConfig
import org.jetbrains.exposed.sql.Schema

fun connectToDatabase(): Database {
    print("Connecting to database.. ")
    return try {
        val database = Database.connect(
            url = "jdbc:mysql://localhost:3306",
            user = "root",
            password = "qFRrXR85*xcY\$5",
            databaseConfig = DatabaseConfig {
                defaultSchema = Schema("gw2")
            }
        )
        println("Success!")
        database
    } catch (e: Exception) {
        println("Failed!")
        throw e
    }
}