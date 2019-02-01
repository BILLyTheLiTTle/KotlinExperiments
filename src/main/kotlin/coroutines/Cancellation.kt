package coroutines

import kotlinx.coroutines.*

fun main(args: Array<String>) {
    val job = Job()

    val scope = CoroutineScope(Dispatchers.Default + job)

    val job1 = doAJob(scope)

    val job2 = doOtherJob(scope)

    //job.cancel() // Cancels the parent job --> doAnotherJob() below is cancelled before ever started
    job.cancelChildren() // Cancels the children jobs but not the parent job --> doAnotherJob() below is running normally

    println("-- Main Job status --\nActive: ${job.isActive}\nCancelled: ${job.isCancelled}\nCompleted: ${job.isCompleted}\n")
    println("-- Job 1 status --\nActive: ${job1.isActive}\nCancelled: ${job1.isCancelled}\nCompleted: ${job1.isCompleted}\n")
    println("-- Job 2 status--\nActive: ${job2.isActive}\nCancelled: ${job2.isCancelled}\nCompleted: ${job2.isCompleted}\n")


    val job3 = doAnotherJob(scope)
    println("-- Job 3 status--\nActive: ${job3.isActive}\nCancelled: ${job3.isCancelled}\nCompleted: ${job3.isCompleted}\n")

    Thread.sleep(100)
}

private fun doAJob(scope: CoroutineScope) = scope.launch { println("I am doing a job"); delay(2000) }
private fun doOtherJob(scope: CoroutineScope) = scope.launch { println("I am doing other job"); delay(2000) }
private fun doAnotherJob(scope: CoroutineScope) = scope.launch { println("I am doing another job"); delay(2000) }