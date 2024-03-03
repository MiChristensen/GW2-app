plugins {
    id("buildlogic.kotlin-library-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.kotlinXHtml)
    implementation(Dependencies.ktorHtmlBuilder)
}