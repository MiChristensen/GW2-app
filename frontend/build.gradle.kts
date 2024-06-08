plugins {
    id("buildlogic.kotlin-library-conventions")
    id("io.miret.etienne.sass") version Versions.sass
}

tasks.compileSass {
    sourceDir = file("${projectDir}/src/main/scss")
    outputDir = layout.buildDirectory.file("/processedResources/main/css").get().asFile

    // outputDir can't be resources/main/css, since gradle complains about the corresponding .scss file
    // when creating the .css file in the same directory. Instead we create the .css file in /processedResources
    // and then copy it to /resources
    doLast {
        copy {
            from(layout.buildDirectory.file("/processedResources/main/css/everything.css"))
            into(layout.buildDirectory.dir("/resources/main/css"))
        }
    }
}

// Compile sass on build
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