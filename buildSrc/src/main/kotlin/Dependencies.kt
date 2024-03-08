object Dependencies {
    val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
    val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    val kotlinXHtml = "org.jetbrains.kotlinx:kotlinx-html-jvm:${Versions.kotlinxHtml}"
    val exposedCore = "org.jetbrains.exposed:exposed-core:${Versions.exposed}"
    val exposedDao = "org.jetbrains.exposed:exposed-dao:${Versions.exposed}"
    val exposedJdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposed}"
    val mySql = "mysql:mysql-connector-java:${Versions.mySql}"
    val slf4jApi = "org.slf4j:slf4j-api:${Versions.slf4j}"
    val slf4jSimple = "org.slf4j:slf4j-simple:${Versions.slf4j}"
    val ktorCore = "io.ktor:ktor-server-core-jvm"
    val ktorLocations = "io.ktor:ktor-server-locations:${Versions.ktor}"
    val ktorHtmlBuilder = "io.ktor:ktor-server-html-builder:${Versions.ktor}"
    // val ktorHost = "io.ktor:ktor-server-host-common-jvm"
    // val ktorStatus = "io.ktor:ktor-server-status-pages-jvm"
    // val ktorCall = "io.ktor:ktor-server-call-logging-jvm"
    // val ktorContent = "io.ktor:ktor-server-content-negotiation-jvm"
    // val ktorSerialization = "io.ktor:ktor-serialization-kotlinx-json-jvm"
    // val ktorAuth = "io.ktor:ktor-server-auth-jvm"
    val ktorNetty = "io.ktor:ktor-server-netty-jvm"
    val ktorServerTests = "io.ktor:ktor-server-tests-jvm"
    val logBack = "ch.qos.logback:logback-classic:${Versions.logBack}"
}