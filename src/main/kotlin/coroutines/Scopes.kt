package coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


fun main(args: Array<String>) {
    val scoped = ScopedCoroutine()

    // Run it in a ScopedCoroutine (scoped) --> Coroutine scope active: true
    val job1 = runBlocking { scoped.doIt() }
    println("Coroutine scope active (job1): ${job1.isActive}")
    Thread.sleep(500)
    // Run it in a GlobalScope (!= scoped context) --> Global scope active: true
    val job2 = runBlocking { scoped.doItGlobally() }
    println("Global scope active (job2): ${job2.isActive}")
    Thread.sleep(500)
    // Run it in a ScopedCoroutine (!= scoped context) --> Other coroutine scope active: true
    val job3 = runBlocking { scoped.doItInOtherScope() }
    println("Other coroutine scope active (job3): ${job3.isActive}")
    Thread.sleep(500)
    // Run it in a ScopedCoroutine(scoped context) --> Another(but same!) coroutine scope active: true
    val job4 = CoroutineScope(scoped.coroutineContext).launch { doItInAnyScope() }
    println("Any(but same!) coroutine scope active (job4): ${job4.isActive}")
    Thread.sleep(500)

    scoped.coroutineContext.cancel()
    println("== Canceling ==")
    Thread.sleep(500)

    // The ScopedCoroutine scoped is canceled so does job1 --> Coroutine scope active: false
    println("Coroutine scope active (job1): ${job1.isActive}")
    Thread.sleep(500)
    // The ScopedCoroutine scoped is canceled but job2 is not because is a GlobalScope coroutine(!=scoped context) --> Global scope active: true
    println("Global scope active (job2): ${job2.isActive}")
    Thread.sleep(500)
    // The ScopedCoroutine scoped is canceled but job3 is not because is a ScopedCoroutine(!=scoped context) --> Other coroutine scope active: true
    println("Other coroutine scope active (job3): ${job3.isActive}")
    Thread.sleep(500)
    // The ScopedCoroutine scoped is canceled so does job4 because is a ScopedCoroutine(scoped context) --> Another(but same!) coroutine scope active: false
    println("Any(but same!) coroutine scope active (job4): ${job4.isActive}")
}

class ScopedCoroutine(): CoroutineScope {
    var scopedJob = Job()

    override val coroutineContext: CoroutineContext
        get() = scopedJob

    fun doIt() = launch(Dispatchers.IO) { delay(100000) }

    fun doItGlobally() = GlobalScope.launch(Dispatchers.IO) { delay(100000) }

    fun doItInOtherScope() = CoroutineScope(Dispatchers.IO).launch { delay(100000) }

}

private suspend fun doItInAnyScope() = coroutineScope { launch(Dispatchers.IO) { delay(100000) } }