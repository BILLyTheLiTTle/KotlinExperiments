package basics

/**
 * Created by Tsapalos on 29/06/17.
 */

fun main(args: Array<String>){
    //PARADIGM 1
    val person = Person("Bill", 31)
    println("This is ${person.name} and he is ${person.age} years old")

}

/*
PARADIGM 1
val variables are immutable, in Java has getter method only
var variables are mutable, in Java has setter and getter methods
const val variables are constant, in java is like final static variable (no getter, no setter)
 */
class Person (val name: String, var age: Int)