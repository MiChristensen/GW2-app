plugins {
    id("buildlogic.kotlin-library-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(Dependencies.kotlinTest)
}
