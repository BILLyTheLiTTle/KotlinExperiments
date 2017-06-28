package basics

/**
 * Created by Tsapalos on 28/06/17.
 */

/*
Just testing the main!
 */
fun main(args: Array<String>){
    println("Hello, world!")

    val a = 1
    val b = 2
    val sumer = sum(a, b)//Oooh, the summer!!!
    println("The sum of $a and $b is $sumer")

    val subt = subtract(a, b)
    println("The subtraction of $a and $b is $subt")
}

fun sum(value1: Int, value2: Int): Int{
    return value1 + value2
}

fun subtract(value1: Int, value2: Int): Int = value1 - value2