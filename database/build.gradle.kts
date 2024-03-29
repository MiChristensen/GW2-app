plugins {
    id("buildlogic.kotlin-library-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.exposedCore)
    implementation(Dependencies.exposedDao)
    implementation(Dependencies.exposedJdbc)
    implementation(Dependencies.mySql)
    implementation(Dependencies.slf4jApi)
    implementation(Dependencies.slf4jSimple)
    implementation(readmodel())
    implementation(coreValue())
}
