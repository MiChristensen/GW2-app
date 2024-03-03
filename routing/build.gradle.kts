
plugins {
    id("org.jetbrains.kotlin.plugin.serialization") version Versions.kotlin
    id("buildlogic.kotlin-application-conventions")
    id("io.ktor.plugin") version Versions.ktor

    application
}

repositories {
    mavenCentral()
}

application {
    mainClass = "gw2.ApplicationKt"
}


dependencies {
    implementation(siteDomain())
    implementation(readmodel())
    implementation(writemodel())

    implementation(Dependencies.kotlinSerialization)
    implementation(Dependencies.kotlinxSerialization)
    implementation(Dependencies.ktorCore)
    implementation(Dependencies.ktorLocations)
    // implementation(Dependencies.ktorHost)
    // implementation(Dependencies.ktorStatus)
    // implementation(Dependencies.ktorCall)
    // implementation(Dependencies.ktorContent)
    // implementation(Dependencies.ktorSerialization)
    // implementation(Dependencies.ktorAuth)
    implementation(Dependencies.ktorNetty)
    // implementation(Dependencies.logBack)
    testImplementation(Dependencies.ktorServerTests)
    testImplementation(Dependencies.kotlinTest)
}
tasks.register("prepareKotlinBuildScriptModel") { }
