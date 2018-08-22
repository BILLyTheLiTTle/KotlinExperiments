package koin

import koin.components.Component
import koin.components.ComponentImplA
import koin.components.ComponentImplB
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleND = module {
    single("ComponentImplA") { ComponentImplA("ND ComponentImplA")  as Component}
    single("ComponentImplB") { ComponentImplB("ND ComponentImplB", 0) as Component}
}

val name = ComponentImplA::class.moduleName
val moduleND2 = module (name){
    single { ComponentImplA("ND: $name")}
}

class NamingDefinition: KoinComponent {

    private val comp: Component by inject(name = "ComponentImplB")

    private val comp2: ComponentImplA by inject(module = name)

    fun printInfo(){
        println(comp.name)
        println(comp2.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleND, moduleND2))
    NamingDefinition().printInfo()

}