package basics

import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by little on 4/7/2017.
 */

/* PARADIGM 1
 The "throw" expression can be used as an expression! What am I saying!
 It is an expression, so it can be used so!
 */
fun canIThrowException(value: Boolean) =
        if (value)
            throw IllegalArgumentException("You decided it! Exception thrown!")
        else
            println("No exception thrown")

/* PARADIGM 2
 Kotlin doesn't differentiate between checked (IOException) and unchecked (NumberFormatException) exceptions
 */
fun printTheNumber(reader: BufferedReader){
    val value = reader.readLine()
    val number = Integer.parseInt(value)
    println(number)
}

/* PARADIGM 3
 Kotlin still has "try-catch-finally" block. The "try" block is an expression in Kotlin.
 "finally" is not used here cuz I was not in a mood.
 Be patient, I will so you how to close an InputStream, but not right now!
 */
fun tryToPrintTheNumber(reader: BufferedReader){
    val value = reader.readLine()
    val number = try {
        Integer.parseInt(value)
    }
    catch(nfe: NumberFormatException){
        "Do you think $value is a number?"
    }
    println(number)
}

fun main(args: Array<String>){

    // PARADIGM 1
    canIThrowException(false) // change it to true to throw the Exception

    // PARADIGM 2
    printTheNumber(BufferedReader(StringReader("12"))) //change to "12a" and see what happens

    // PARADIGM 3
    tryToPrintTheNumber(BufferedReader(StringReader("12a")))
}