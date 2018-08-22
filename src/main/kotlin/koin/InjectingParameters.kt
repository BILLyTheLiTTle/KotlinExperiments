package koin

import koin.components.ComponentImplA
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleIP = module {
    single { (name: String) -> ComponentImplA(name) }
}

class InjectingParameters: KoinComponent {

    private val comp: ComponentImplA by inject { parametersOf("IP ComponentImplA") }

    fun printInfo(){
        println(comp.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleIP))
    InjectingParameters().printInfo()
}