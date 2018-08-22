package koin

import koin.components.BabushkaComponent
import koin.components.BabushkaComponentImplA
import koin.components.Component
import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleBD = module {
    // You can use "as" Kotlin operator
    single { ComponentImplA("BD Component") as Component }

    // OR

    // Inferred type form
    // single<Component> { ComponentImplA("BD Component") }

    // OR
    // Bind additional type with "bind" operator - have both types (ComponentImplA & Component)
    // single { ComponentImplA("BD Component") } bind Component::class
    // single { BabushkaComponentImplA(get()) }

    single { BabushkaComponent(get()) }
}

class BindDefinition: KoinComponent {

    private val babComp: BabushkaComponent by inject()

    // Uncomment the below when use "bind" operator
    // private val babComp2: BabushkaComponentImplA by inject()

    fun printInfo(){
        println(babComp.comp.name)

        // Uncomment the below when use "bind" operator
        //println(babComp2.comp.name)
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleBD))
    BindDefinition().printInfo()
}