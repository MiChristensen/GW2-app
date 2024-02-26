plugins {
    id("buildlogic.kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(Dependencies.exposedCore)
    implementation(Dependencies.exposedDao)
    implementation(Dependencies.exposedJdbc)
    implementation(Dependencies.mySql)
    implementation(project(":utilities"))
    implementation(project(":db"))
    implementation(project(":readmodel"))
    implementation(project(":writemodel"))
    implementation(project(":core-value"))
}

application {
    // Define the main class for the application.
    mainClass = "org.example.app.AppKt"
}
