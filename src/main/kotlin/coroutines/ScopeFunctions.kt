package coroutines

import kotlinx.coroutines.*

var coJob1: Job? = null
var coJob2: Job? = null

var suJob1: Job? = null
var suJob2: Job? = null

var childJob: Job? = null

fun main(args: Array<String>) {
    val job = SupervisorJob() // --> One child's failure doesn't drive all children to failure.
    //val job = Job() // --> One child's failure drives all children to failure.

    val scope = CoroutineScope(Dispatchers.Default + job)

    scope.launch {
        // When other children fail, it survives the failure if SupervisorJob is used
        childJob = scope.launch { delay(10000) }

        // When other children fail, it survives the failure if SupervisorJob is used
        scope.launch { doItInCoroutineScope() }

        // When other children fail, it survives the failure if SupervisorJob is used
        scope.launch { doItInSupervisorScope() }
    }
    Thread.sleep(600)

    println("-- Coroutine Job 1 status --\nActive: ${coJob1!!.isActive}\nCancelled: ${coJob1!!.isCancelled}\nCompleted: ${coJob1!!.isCompleted}\n")
    println("-- Coroutine Job 2 status --\nActive: ${coJob2!!.isActive}\nCancelled: ${coJob2!!.isCancelled}\nCompleted: ${coJob2!!.isCompleted}\n")

    println("-- Supervisor Job 1 status --\nActive: ${suJob1!!.isActive}\nCancelled: ${suJob1!!.isCancelled}\nCompleted: ${suJob1!!.isCompleted}\n")
    println("-- Supervisor Job 2 status --\nActive: ${suJob2!!.isActive}\nCancelled: ${suJob2!!.isCancelled}\nCompleted: ${suJob2!!.isCompleted}\n")

    println("-- Child Job status --\nActive: ${childJob!!.isActive}\nCancelled: ${childJob!!.isCancelled}\nCompleted: ${childJob!!.isCompleted}\n")

}


private suspend fun doItInCoroutineScope() = coroutineScope {
    // When any of the following children fails the other will fail too always
    coJob1 = launch { println("Coroutine scope 1st"); delay(500); throw Exception() }
    coJob2 = launch { println("Coroutine scope 2nd"); delay(1000)}
}

private suspend fun doItInSupervisorScope() = supervisorScope {
    // No matter if any of the following children fails the other will not fail
    suJob1 = launch { println("Supervisor scope 1st"); delay(500); throw Exception() }
    suJob2 = launch { println("Supervisor scope 2nd"); delay(1000)}
}