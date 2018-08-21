package koin

import koin.components.BabooskaComponent
import koin.components.Component
import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleRD = module {
    // not retrieved by get() cuz it is "ComponentImplA" type and not "Component" type
    single { ComponentImplA("RD ComponentImpl") }
    single<Component> { ComponentImplA("RD Component") }
    single { BabooskaComponent(get()) }
}

class ResolveDependency: KoinComponent {

    private val babComp: BabooskaComponent by inject<BabooskaComponent>()

    fun printInfo(){
        println(babComp.comp.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleRD))
    ResolveDependency().printInfo()
}