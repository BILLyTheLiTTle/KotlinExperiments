package koin

import koin.components.Component
import koin.components.ComponentImplA
import koin.components.ComponentImplB
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject

val moduleDF = module {
    single { ComponentImplA("DF ComponentImplA") as Component }
}
val moduleDF2 = module(override=true) {
    single { ComponentImplB("DF ComponentImplB", 1) as Component }
}

// OR
/*val moduleDF3 = module {
    single { ComponentImplA("DF ComponentImplA") as Component }
    single(override=true) { ComponentImplB("DF ComponentImplB", 1) as Component }
}*/

class DefinitionFlags: KoinComponent {

    private val comp: Component by inject()

    fun printInfo(){
        println(comp.name)
    }
}

fun main(args: Array<String>) {
    startKoin(listOf(moduleDF, moduleDF2))

    // OR
    // startKoin(listOf(moduleDF3))

    DefinitionFlags().printInfo()
}