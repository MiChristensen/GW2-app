plugins {
    id("buildlogic.kotlin-library-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(readmodel())
    implementation(coreValue())

    testImplementation(Dependencies.kotlinTest)
}