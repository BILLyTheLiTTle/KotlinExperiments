package koin

import koin.components.BabushkaComponentImplA
import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleRD = module {
    single { ComponentImplA("RD Component") }
    single { BabushkaComponentImplA(get()) }
}

class ResolveDependency: KoinComponent {

    private val babComp: BabushkaComponentImplA by inject()

    fun printInfo(){
        println(babComp.comp.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleRD))
    ResolveDependency().printInfo()
}