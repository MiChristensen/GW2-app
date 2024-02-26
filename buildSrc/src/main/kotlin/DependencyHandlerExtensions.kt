import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.app() = project(":app")

fun DependencyHandler.coreValue() = project(":coreValue")
fun DependencyHandler.database() = project(":database")
fun DependencyHandler.readmodel() = project(":readmodel")
fun DependencyHandler.sharedUtil() = project(":sharedUtil")
fun DependencyHandler.writemodel() = project(":writemodel")

