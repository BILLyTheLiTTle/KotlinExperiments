package coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    var j = 0
    var k = 0
    var l = 0

    // It blocks the main thread so it guarantees this will run to the end
    val runBlockingTime = measureTimeMillis {
        runBlocking(Dispatchers.IO) {
            for (i in 0..1000000000) {
                k = i
            }
        }
    }

    // Needs await() to block the parent coroutine or else you don't guarantee what will be run
    val asyncTime = measureTimeMillis {
        //runBlocking(Dispatchers.IO) {
            GlobalScope.async(Dispatchers.IO) {
                for (i in 0..1000000000) {
                    j = i
                }
            }//.await()
        //}
    }

    // Just runs and you will get no guarantee of what is going on
    val launchTime = measureTimeMillis {
        GlobalScope.launch(Dispatchers.IO) {
            for (i in 0..1000000000) {
                l = i
            }
        }
    }

    println("Async($j): $asyncTime\nBlock($k): $runBlockingTime\nLaunch($l): $launchTime")
}