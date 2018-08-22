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
    // --- START ---
    // You can use "as" Kotlin operator
    single { ComponentImplA("BD Component") as Component }

    // OR

    // Inferred type form
    // single<Component> { ComponentImplA("BD Component") }

    // OR

    // Bind additional type with "bind" operator - have both types (ComponentImplA & Component)
    // single { ComponentImplA("BD Component") } bind Component::class
    // single { BabushkaComponentImplA(get()) }
    // --- END ---

    single { BabushkaComponent(get()) }
}

class BindDefinition: KoinComponent {

    // --- START ---
    private val babComp: BabushkaComponent by inject()

    //OR

    // Uncomment the below when use "bind" operator
    // private val babComp2: BabushkaComponentImplA by inject()
    // --- END ---

    fun printInfo(){
        // --- START ---
        println(babComp.comp.name)

        // OR

        // Uncomment the below when use "bind" operator
        //println(babComp2.comp.name)
        // --- END ---
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleBD))
    BindDefinition().printInfo()
}