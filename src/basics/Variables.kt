package basics

import java.util.*

/**
 * Created by Tsapalos on 29/06/17.
 */

/*
PARADIGM 1 - check main
Declaring and assigning a variable simultaneously
 */
val oneHundred = 10e1

/*
PARADIGM 2 - check main
Mutable, immutable, constant references
 */
val date = Date()// immutable
var aNumber = 2 // mutable
const val anotherNumber = 3 // constant
//const var wtf = 0 --> compile time error. Const and var? together?!

/*PARADIGM 3 - check main
Declaring and use an array
 */
val numbersArray: IntArray = intArrayOf(1, 2, 3)

fun main(args: Array<String>){
    //PARADIGM 1
    println(oneHundred) // prints 100.0

    //PARADIGM 2
    println("The initial date I have is: $date") // prints Thu Jun 29 13:34:44 EEST 2017
    //date = Date() --> throws compile time error because this is a val
    date.time = 0
    println("The date I have now is: $date") // prints Thu Jan 01 02:00:00 EET 1970
    //Remember, the reference is immutable, not the object itself

    //PARADIGM 3
    println("Number one is not $numbersArray[0] but it is ${numbersArray[0]}")

}