package koin

import koin.components.ComponentImplA
import koin.components.ComponentImplB
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.koin.standalone.release

val moduleL1 = module("a") {
    single { ComponentImplA("1") }
}
val moduleL2 = module("b") {
    single { ComponentImplB("2", 2) }
}

class Lifecycle: KoinComponent {

    private val componentA: ComponentImplA by inject()
    private val componentB: ComponentImplB by inject()

    fun printInfo(){
        println(componentA.name)
        println(componentB.name)

        // Don't forget to release the modules when you need them no more
        release("a")
        release("b")
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleL1))

    // You cannot start again the container but you can load more modules later in this way
    StandAloneContext.loadKoinModules(listOf(moduleL2))

    Lifecycle().printInfo()

    // Don't forget to stop the container
    StandAloneContext.stopKoin()

    /* At the other examples I am not releasing modules or stopping the container cuz "main" function dies
        and every instance started with her!
     */
}