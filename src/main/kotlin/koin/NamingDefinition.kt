package koin

import koin.components.Component
import koin.components.ComponentImplA
import koin.components.ComponentImplB
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleND = module {
    single("ComponentImplA") { ComponentImplA("ND ComponentImplA")  as Component}
    single("ComponentImplB") { ComponentImplB("ND ComponentImplB", 0) as Component}
}

class NamingDefinition: KoinComponent {

    private val comp: Component by inject(name = "ComponentImplB")

    fun printInfo(){
        println(comp.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleND))
    NamingDefinition().printInfo()

}