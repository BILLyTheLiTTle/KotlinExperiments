package basics

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

/*
 Just testing the main through the "Hello World"!
 */
fun main(args: Array<String>){
    println("Hello, world!")

    //PARADIGM 1
    val a = 1
    val b = 2
    val sumer = sum(a, b)//Oooh, the summer!!!
    println("The sum of $a and $b is $sumer")

    //PARADIGM 2
    val subt = subtract(a, b)
    println("The subtraction of $a and $b is $subt")
}
