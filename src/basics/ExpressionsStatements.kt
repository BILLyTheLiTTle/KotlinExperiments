package basics

import java.util.*

/**
 * Created by Tsapalos on 30/06/17.
 */

/* PARADIGM 1
 The "if" statement....ooops, I mean expression!
 The "if" and "when" expressions return a value.
 There is no need for "return" keyword.
 There is no need for ternary operator.
 Comment/Uncomment the parts of the body of the function that you would like to test
 */
fun max(value1: Int, value2: Int): Int {
    val comparison = value1 > value2
    //if (comparison) return value1 else return value2
    //return if (comparison) value1 else value2
    return when {(comparison) -> value1 else -> value2}
}
/* PARADIGM 2
 Show how simple iteration is done
 */
fun explainSimpleIteration() =
        println("I am not going to do this right now.\nThere are the following loops:\n" +
                "- while\n- do-while\n- for-each (in Kotlin you have only the for-each loop)\n" +
                "All of the above are like Java.")

/* PARADIGM 3
 Kotlin has only the for-each loop.
 But I want to repeat a block of code using the for.
 How can I do it?
 The answer is you can't, that's why Kotlin is so easy.
 It misses a lot for features just to keep it simple!
 Really? Do you believe me?
 */
fun workWithMissingForLoops(){
    for(i in 1..10) // 10 is included
        print("$i ")

    println()

    for(i in 1 until 10) // 10 is excluded
        print("$i ")

    println()

    for (i in 'a'..'z' step 5)
        print("$i ")

    println()

    for (i in 10 downTo 1 step 2)
        print("$i ")

    println()

    for (i in 'Z' downTo 'A' step 2)
        print("$i ")
}

/* PARADIGM 4
 Iterate a Map
 */
val aMap = TreeMap<Int, Char>()
fun fillTheMapAndParse() {
    var i = 1;
    for (c in 'A'..'Z') {
        aMap[i] = c
        i++
    }
    for ((key, value) in aMap) { // this is a destructuring declaration
        println("$key = $value")
    }
}

/* PARADIGM 5
 The "in" operator can be used to in value checks
 */
fun isSmallLetter() = 'b' in 'a'..'z'
fun isNotBetweenZeroToNine() = 1 !in 0..9

fun main(args: Array<String>){

    // PARADIGM 1
    println(max(1,2))

    // PARADIGM 2
    explainSimpleIteration()

    // PARADIGM 3
    workWithMissingForLoops()

    // PARADIGM 4
    fillTheMapAndParse()

    // PARADIGM 5
    println(isSmallLetter())
    println(isNotBetweenZeroToNine())
}