package koin

import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.koin.standalone.get

val moduleS = module {
   single { ComponentImplA("S") }
}

class SingletonComponent: KoinComponent {

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
    StandAloneContext.startKoin(listOf(moduleS))
    val singleton = SingletonComponent()
    singleton.printInfo()

}