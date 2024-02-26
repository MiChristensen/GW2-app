plugins {
    id("buildlogic.kotlin-library-conventions")
}

dependencies {
    implementation(project(":core-value"))
}

// plugins {
//     kotlin("jvm") version "1.9.20"
// }
//
// group = "org.example"
//
// repositories {
//     mavenCentral()
// }
//
// dependencies {
//     testImplementation("org.jetbrains.kotlin:kotlin-test")
// }
//
// tasks.test {
//     useJUnitPlatform()
// }
// kotlin {
//     jvmToolchain(19)
// }