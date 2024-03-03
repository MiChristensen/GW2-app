
rootProject.name = "GW2-app"


plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

include("app")
include("sharedUtil")
include("database")
include("readmodel")
include("writemodel")
include("coreValue")
include("routing")
