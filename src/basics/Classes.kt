package basics

/**
 * Created by Tsapalos on 29/06/17.
 */

fun main(args: Array<String>){
    //PARADIGM 1
    val person = Person("Bill", 31)
    println("This is ${person.name} and he is ${person.age} years old")

    //PARADIGM 2
    val girl = Woman("Sissy")
    girl.age = 24
    println("My name is ${girl.name} and I am ${girl.age} years old") // It's a woman! She will not tell you her age!

}

/*
PARADIGM 1 - check main
val variables are immutable, in Java has getter method only
var variables are mutable, in Java has setter and getter methods
const val variables are constant, in java is like final static variable (no getter, no setter)
 */
class Person (val name: String, var age: Int)

/*
PARADIGM 2 - check main
A class with custom getter and setter method
 */
class Woman (val name: String){
    var age: Int = -1
    get() = -1 // see Functions.kt for functions with expression body
    set(value) {
        println("Age is set")
        field = value
    }
}