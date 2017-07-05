package basics

import java.util.*

/**
 * Created by Tsapalos on 28/06/17.
 */

/*
 PARADIGM 1 - check main
 Declaring a function with a block body
 */
fun sum(value1: Int, value2: Int): Int{
    return value1 + value2
}

/*
 PARADIGM 2 - check main
 Declaring a function with expression body. The return statement is optional here
 */
fun subtract(value1: Int, value2: Int): Int = value1 - value2
// OR
//fun subtract(value1: Int, value2: Int) = value1 - value2

/* PARADIGM 3
 (a)The named arguments, (b)the "to" function and (c)the print without "toString"

 (a) I have created a function with a lot of parameters. Don't feel angry, I could add even more!
 If I would call the function using a regular call syntax maybe this will be chaotic.
 I would be lost in all these parameters. That's why I will call this function using named arguments.
 (a.1) Take a good at the row of the parameters passed during the call. The row is not fixed!
 (a.2) Take a look at the value assignment during the argument declaration and
 the call (second call inside main) of the same method.
 That's how you declare default parameter values. Does this mean that overloading is over?!
 (b) This is a function, an infix function.
 (c) There is a default toString implementation

 PITFALL: When using the regular call syntax, you can omit only trailing arguments (if default parameter values exist).
 If you use named arguments, you can omit some arguments from the middle of the list
 and specify only the ones you need (if default parameter values exist).
 */
fun createAMap(key1: Int, value1: String, key2: Int, value2: String, key3: Int = 3, value3: String = "three"){
    val myMap = mapOf<Int, String>(key1 to value1, key2 to value2, key3 to value3)
    println("The map I created is $myMap")
}

/* PARADIGM 4
 This is called extension function.
 It is defined outside of the class (Random class at this example) but it can be called like if it was inside.
 Look at the main method to see how it can be called so that you will understand the "this" reference
 (which can be omitted if you want to). You just added a function to Random class without editing it, or extend it.

 PITFALL: You still don't have to private or protected members of the original class.
 */
fun Random.nextCapitalChar() = (this.nextInt(25) + 65).toChar()

fun main(args: Array<String>){
    // Just testing the main through the "Hello World"!
    println("Hello, world!")

    //PARADIGM 1
    val a = 1
    val b = 2
    val sumer = sum(a, b)//Oooh, the summer!!!
    println("The sum of $a and $b is $sumer")

    //PARADIGM 2
    val subt = subtract(a, b)
    println("The subtraction of $a and $b is $subt")

    // PARADIGM 3
    createAMap(key1 = 1, key2 = 2, key3 = 3, value1 = "one", value2 = "two", value3 = "three")
    createAMap(key1 = 1, key2 = 2, value1 = "one", value2 = "two", value3 = "three")

    // PARADIGM 4
    println("${Random(System.currentTimeMillis()).nextCapitalChar()}")
}
