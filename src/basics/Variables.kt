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
val date = Date()// immutable, in Java has getter method only
var aNumber = 2 // mutable, in Java has setter and getter methods
const val anotherNumber = 3 // constant, in java is like final static variable (no getter, no setter)
//const var wtf = 0 --> compile time error. Const and var? together?!

fun main(args: Array<String>){
    //PARADIGM 1
    println(oneHundred) // prints 100.0

    //PARADIGM 2
    println(date) // prints Thu Jun 29 13:34:44 EEST 2017
    //date = Date() --> throws compile time error because this is a val
    date.time = 0
    println(date) // prints Thu Jan 01 02:00:00 EET 1970
    //Remember, the reference is immutable, not the object itself

}