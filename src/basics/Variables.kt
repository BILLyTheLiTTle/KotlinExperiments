package basics

import java.util.*

/**
 * Created by Tsapalos on 29/06/17.
 */

/*
PARADIGM 1
Declaring and assigning a variable simultaneously
 */
val oneHundred = 10e1

/* PARADIGM 2 - check main
 Mutable, immutable, constant references.
 If you don't understand the comments I put below, open this file in IntelliJ IDEA and go to menu bar ->
 Tools -> Kotlin -> Show Kotlin Bytecode and you will understand one and for all
 */
val date = Date()// val variables are immutable, in Java has getter method only
var aNumber = 2 // var variables are mutable, in Java has setter and getter methods
const val anotherNumber = 3 // const val variables are constant, in java is like final static variable
                            // (no getter, no setter)
//const var wtf = 0 --> compile time error. Const and var? together?!

/*PARADIGM 3
Declaring and use an array
 */
val numbersArray: IntArray = intArrayOf(1, 2, 3)

/* PARADIGM 4
 Declaring and use Map.
 Get/Set values to Map just like an array.
 You can do this through operator overloading! I will explain it in the near future.
 TODO mention here the file which shows operator overloading
 */
val numberToChar = TreeMap<Int, Char>()
fun fillTheMap(){
    numberToChar.set(1,'a')
    numberToChar[2] = 'b'
    println("The 1st item is ${numberToChar[1]} and the 2nd is ${numberToChar.get(2)}")
}

/* PARADIGM 5
 This is called extension property.
 These properties don't have any state. You cannot add extra fields to existing instances of Java objects.
 Comment the line with the "get" method and uncomment the " ='a' " area and see the error.
 */
val Random.nextCapitalChar: Char //= 'a'
        get() = (this.nextInt(25) + 65).toChar()

fun main(args: Array<String>){
    //PARADIGM 1
    println("PARADIGM 1")
    println(oneHundred) // prints 100.0

    //PARADIGM 2
    println("\nPARADIGM 2")
    println("The initial date I have is: $date") // prints Thu Jun 29 13:34:44 EEST 2017
    //date = Date() --> throws compile time error because this is a val
    date.time = 0
    println("The date I have now is: $date") // prints Thu Jan 01 02:00:00 EET 1970
    //Remember, the reference is immutable, not the object itself

    //PARADIGM 3
    println("\nPARADIGM 3")
    println("Number one is not $numbersArray[0] but it is ${numbersArray[0]}")

    // PARADIGM 4
    println("\nPARADIGM 4")
    fillTheMap()

    // PARADIGM 5
    println("\nPARADIGM 5")
    println("${Random(System.currentTimeMillis()).nextCapitalChar}")

}