package koin

import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleS = module {
   single { ComponentImplA("S") }
}

class SingletonComponent: KoinComponent {

    private val componentA: ComponentImplA by inject()

   fun printInfo(){
       println(componentA.name)
   }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleS))
    val singleton = SingletonComponent()
    singleton.printInfo()

}