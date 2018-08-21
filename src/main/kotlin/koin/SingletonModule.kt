package koin

import koin.components.Component
import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

val moduleA = module {
   single { ComponentImplA("A") }
}

class SingletonModule: KoinComponent {

   val componentA: ComponentImplA by inject<ComponentImplA>()

   fun printInfo(){
      println(componentA.name)
   }
}

fun main(args: Array<String>) {
   StandAloneContext.startKoin(listOf(moduleA))
   SingletonModule().printInfo()

}