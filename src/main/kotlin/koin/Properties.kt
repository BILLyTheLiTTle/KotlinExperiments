package koin

import koin.components.ComponentImplA
import org.koin.dsl.module.module
import org.koin.standalone.*

val moduleP1 = module {
    single { ComponentImplA(getProperty("author_nickname", "oops")) }
}

class Properties: KoinComponent {

    private val componentA: ComponentImplA by inject()

    fun printInfo(){
        val oldAuthor = componentA.name
        val newAuthor = "Enter_your_nickname_here"
        setProperty("author_nickname", newAuthor)
        println("The old author was: ${getProperty<String>("real_author_name", "oops")} " +
                "aka \"$oldAuthor\" " +
                "but now it is ${getProperty<String>("author_nickname", "oops")}")
    }
}

fun main(args: Array<String>) {
    StandAloneContext.startKoin(listOf(moduleP1),
        useKoinPropertiesFile = true, extraProperties = mapOf(Pair("real_author_name", "Bill")))
    Properties().printInfo()
}