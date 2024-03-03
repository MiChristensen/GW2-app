package gw2.app

import connectToDatabase
import gw2.ContentFactory
import gw2.serveRoutes
import org.jetbrains.exposed.sql.Database

fun main() {
    val database = database()
    val contentFactory = contentFactory(database)
    serveRoutes(contentFactory)
}

private fun database(): Database {
    return connectToDatabase()
}

private fun contentFactory(database: Database): ContentFactory {
    return ContentFactoryImpl(database)
}