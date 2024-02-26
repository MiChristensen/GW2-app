plugins {
    id("buildlogic.kotlin-application-conventions")
    application
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(Dependencies.exposedCore)
    implementation(Dependencies.exposedDao)
    implementation(Dependencies.exposedJdbc)
    implementation(Dependencies.mySql)
    implementation(sharedUtil())
    implementation(database())
    implementation(readmodel())
    implementation(writemodel())
    implementation(coreValue())
}

application {
    // Define the main class for the application.
    mainClass = "gw2.app.AppKt"
}
