package koin

import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleF = module {
    factory { ComponentImplA("F") }
}

class FactoryComponent: KoinComponent {

    private val componentA: ComponentImplA by inject<ComponentImplA>()

    fun printInfo(){
        println(componentA.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleF))
    val factory = FactoryComponent()
    factory.printInfo()
}