package basics

import java.util.*

/* PARADIGM 5
 In "ExpressionsStatements" class there is a method "max".
 It is useless to import a method that already belongs to the same package but I would like to try the "as" keyword.
 From now on, in this file I could call the "max" as "maxInt".

 This is useful in case you import several functions with the same name from different packages.
 You can also import them using the full name (package.one.FunctionName and package.two.FunctionName)
 but if you have extension functions this is the only way to resolve the conflict.

 NOTE: Method "max" cannot be called at this file. It is "maxInt".
 */
import basics.max as maxInt

/**
 * Created by Tsapalos on 28/06/17.
 */

/* PARADIGM 1
 Declaring a function with a block body
 */
fun sum(value1: Int, value2: Int): Int{
    return value1 + value2
}

/*
 PARADIGM 2
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

 If you see Kotlin ByteCode (menu toolbar -> Tools -> Kotlin -> Kotlin ByteCode) you will see that
 this method is declared as static (and final also). So, there is no overriding for you, sir!

 PITFALL: You still don't have access to private or protected members of the original class.
 */
fun Random.nextCapitalChar() = (this.nextInt(25) + 65).toChar()

/* PARADIGM 6
 Extension functions depend on the static type of the variable being declared,
 not on the runtime type of the value stored in that variable
 */
fun Any.hello() = "Hello from Any"
fun String.hello() = "Hello from String"

/* PARADIGM 7
 In case an extension function has the same name with a member function, the extension functions takes precedence.
 If you want to run the example with the original "toUpperCase" method, just comment the line below.
 */
fun String.toUpperCase() = "It is not the original toUpperCase() method"

/* PARADIGM 8
 The varargs keyword let you specify an arbitrary number of parameters for a function.

 PITFALL: If you pass an array as vararg argument you have to explicitly unpack it using the spread operator.
 You can do this by putting an asterisk (*) before the array that you want to be expanded
 */
fun printAllArgs(vararg values: Int) {
    for (value in values)
        print(value)
    println()
}

/* PARADIGM 9
 Maybe this example is to complex for the explaining the infix modifier.
 The moral of the story is that I can omit the dot (.) after the object and before the method call!
 And the parenthesis also! It looks like an every day language.
 */
infix fun Int.add(that: Int) = this + that

/* PARADIGM 10
 Nested functions. It is not a good example of the nested functions. It is so unnecessary, but it is simple!

 Note that local functions have access to all parameters and variables of the enclosing function
 and you are to go!
 */
fun printMin(value1: Int, value2: Int) {
    fun startProgress() = println("I will find the minimum number!")
    fun middleProgress(): Int {
        println("I am doing it right now...")
        return if (value1 < value2) value1 else value2
    }
    fun endProgress(min: Int) = println("Found it: $min")

    startProgress()
    val min = middleProgress()
    endProgress(min)
}

fun main(args: Array<String>){
    // Just testing the main through the "Hello World"!
    println("Hello, world!")

    //PARADIGM 1
    println("\nPARADIGM 1")
    val a = 1
    val b = 2
    val sumer = sum(a, b)//Oooh, the summer!!!
    println("The sum of $a and $b is $sumer")

    //PARADIGM 2
    println("\nPARADIGM 2")
    val subt = subtract(a, b)
    println("The subtraction of $a and $b is $subt")

    // PARADIGM 3
    println("\nPARADIGM 3")
    createAMap(key1 = 1, key2 = 2, key3 = 3, value1 = "one", value2 = "two", value3 = "three")
    createAMap(key1 = 1, key2 = 2, value1 = "one", value2 = "two", value3 = "three")

    // PARADIGM 4
    println("\nPARADIGM 4")
    println("${Random(System.currentTimeMillis()).nextCapitalChar()}")

    // PARADIGM 5
    println("\nPARADIGM 5")
    println("The max integer is ${maxInt(1,2)}")

    // PARADIGM 6
    println("\nPARADIGM 6")
    val sth: Any = "String"
    println(sth.hello())

    // PARADIGM 7
    println("\nPARADIGM 7")
    println("all letters are capital".toUpperCase())

    // PARADIGM 8
    println("\nPARADIGM 8")
    printAllArgs(1, 2, 3, 10)
    val intArr = intArrayOf(1, 2, 3, 4, 5)
    printAllArgs(*intArr)

    // PARADIGM 9
    println("\nPARADIGM 9")
    println(1 add 2)
    println(1.add(2)) // The same as above

    // PARADIGM 10
    println("\nPARADIGM 10")
    printMin(1,2)
}
