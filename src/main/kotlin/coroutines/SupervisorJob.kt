package coroutines

import kotlinx.coroutines.*
import java.lang.Exception

fun main(args: Array<String>) {
    // Comment - uncomment any the 2 lines below and compare the console output
    val job = SupervisorJob() //Is this a function?! It looks like a class/interface!!!
    //val job = Job()

    val scope = CoroutineScope(Dispatchers.Default + job)

    var grandChild: Job? = null

    runBlocking {
        val child1 = scope.launch {
            println("1st child coroutine started")
            grandChild = launch {
                println("1-1st child coroutine started")
                delay(3000)
            }
            delay(500)
            throw Exception()
        }

        val child2 = scope.launch {
            println("2nd child coroutine started")
            delay(2000)
        }
        delay(1000)
        println("-- 1st child status--\nActive: ${child1.isActive}\nCancelled: ${child1.isCancelled}\nCompleted: ${child1.isCompleted}\n")
        println("-- 1-1st child status--\nActive: ${grandChild!!.isActive}\nCancelled: ${grandChild!!.isCancelled}\nCompleted: ${grandChild!!.isCompleted}\n")
        println("-- 2nd child status--\nActive: ${child2.isActive}\nCancelled: ${child2.isCancelled}\nCompleted: ${child2.isCompleted}\n")
    }

}