plugins {
    id("buildlogic.kotlin-library-conventions")
    id("io.miret.etienne.sass") version Versions.sass
}

val buildDirectory = layout.buildDirectory

tasks.compileSass {
    sourceDir = file("${projectDir}/src/main/resources/css")
    outputDir = buildDirectory.file("/processedResources/main/css").get().asFile
    // outputDir can't be resources/main/css, since gradle complains about the corresponding .scss file
    // when creating the .css file in the same directory. Instead we create the .css file in /processedResources
    // and then copy it to /resources
    copy {
        from(outputDir)
        into(buildDirectory.file("/resources/main/css"))
    }
}

// Compile sass on compile
tasks.compileKotlin {
    dependsOn(tasks.compileSass)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.kotlinXHtml)
    implementation(Dependencies.ktorHtmlBuilder)
}