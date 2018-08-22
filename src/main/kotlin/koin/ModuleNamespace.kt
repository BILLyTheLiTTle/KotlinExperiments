package koin

import koin.components.*
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

// --- START ---
val moduleMN = module ("module.namespace") {
    module ("a") { single { ComponentImplA("MN ComponentImplA") as Component } }
    module ("b") { single { ComponentImplB("MN ComponentImplB", 0) as Component } }
}

// OR
// Uncomment this to see that there is no difference
/*val moduleMN = module ("module") {
    module ("namespace") {
        module("a") { single { ComponentImplA("MN ComponentImplA") as Component } }
        module("b") { single { ComponentImplB("MN ComponentImplB", 0) as Component } }
    }
    // Uncomment below to see the error (Component for "module.namespace.a or b" is not visible in module.another.c
    /*module ("another") {
        module("c") { single { BabushkaComponent(get()) } }
    }*/
}*/
// --- END ---

class ModuleNamespace: KoinComponent {

    // --- START ---
    private val comp: Component by inject(module = "module.namespace.a")

    // OR

    // Uncomment this to see that there is no difference
    // private val comp: Component by inject(module = "a")
    // --- END ---

    // Uncomment also here to see the visibility error
    // private val babComp: BabushkaComponent by inject(module = "module.another.c")

    fun printInfo(){
        println(comp.name)

        // Uncomment also here to see the visibility error
        // println(babComp.comp.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleMN))
    ModuleNamespace().printInfo()
}