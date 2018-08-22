package koin

import koin.components.Component
import koin.components.ComponentImplA
import koin.components.ComponentImplB
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleMN = module ("module.namespace") {
    module ("a") { single { ComponentImplA("MN ComponentImplA") as Component } }
    module ("b") { single { ComponentImplB("MN ComponentImplB", 0) as Component } }
}

class ModuleNamespace: KoinComponent {

    // --- START ---
    private val comp: Component by inject(module = "module.namespace.a")

    // OR

    // Uncomment this to see that there is no difference
    // private val comp: Component by inject(module = "a")
    // --- END ---

    fun printInfo(){
        println(comp.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleMN))
    ModuleNamespace().printInfo()
}