package koin

import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.koin.standalone.get

val moduleF = module {
    factory { ComponentImplA("F") }
}

class FactoryComponent: KoinComponent {

    // -- START ---
    // Retrieving definition lazily
    private val componentA: ComponentImplA by inject()

    // OR

    // Retrieving definition not lazily
    // Uncomment below to run the example using get
    // private val componentA = get<ComponentImplA>()
    // --- END ---

    fun printInfo(){
        println(componentA.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleF))
    val factory = FactoryComponent()
    factory.printInfo()
}