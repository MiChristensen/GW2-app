import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.app() = project(":app")
fun DependencyHandler.routing() = project(":routing")
fun DependencyHandler.coreValue() = project(":coreValue")
fun DependencyHandler.frontend() = project(":frontend")
fun DependencyHandler.database() = project(":database")
fun DependencyHandler.readmodel() = project(":readmodel")
fun DependencyHandler.sharedUtil() = project(":sharedUtil")
fun DependencyHandler.writemodel() = project(":writemodel")
fun DependencyHandler.siteDomain() = project(":siteDomain")


