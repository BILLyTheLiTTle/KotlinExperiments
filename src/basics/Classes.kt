package basics

/**
 * Created by Tsapalos on 29/06/17.
 */

/*
 PARADIGM 1
 val variables are immutable, in Java has getter method only
 var variables are mutable, in Java has setter and getter methods
 const val variables are not allowed inside a class
 */
class Person (val name: String, var age: Int)

/*
 PARADIGM 2
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

/* PARADIGM 3
 Different ways to declare a class and its primary constructor.

 constructor: Begins the declaration of a primary or secondary constructor. Of course, you  could have a private
                constructor in case you don't want the class to be instantiated.
 init: This block contains initialization code which is executed when the class is created through the primary
        constructor. You can declare several initializer blocks in a class (see what happens in main function)
 */
class SomeClass constructor(_item: String){
    val item: String
    val item1:String
    val item2: Int
    init {
        item = _item
    }
    init {
        item2 = 2
        item1 = "$_item as Item No$item2"
    }
}
// OR, simpler...
class SomeClassA(_item: String){
    val item: String
    init {
        item = _item
    }
}
// OR, even simpler...
class SomeClassB(val item: String)

/* PARADIGM 4
 A class may have secondary constructors without a primary one.
 */
open class AnotherClass{
    constructor(value: Int){
        //initialization code here
    }
}

/* PARADIGM 5
 Extending a class and declare the same secondary constructor.
 */
class AnotherClassSubclass: AnotherClass {
    constructor(value: Int): super(value)
}

/* PARADIGM 6
 Constructor with a default parameter. Just like functions.
 Does this mean that overloading in constructors is, also, over?!
 */
class OneMoreClass(val item1: Int =1, val item2: Int =2)

fun main(args: Array<String>){
    //PARADIGM 1
    println("PARADIGM 1")
    val person = Person("Bill", 31)
    println("This is ${person.name} and he is ${person.age} years old")

    //PARADIGM 2
    println("\nPARADIGM 2")
    val girl = Woman("Sissy")
    girl.age = 24
    println("My name is ${girl.name} and I am ${girl.age} years old") // It's a woman! She will not tell you her age!

    //PARADIGM 3
    println("\nPARADIGM 3")
    val someClass = SomeClass("SomeClass Item")
    println("${someClass.item}")
    println("${someClass.item1}")

    //PARADIGM 6
    println("\nPARADIGM 6")
    val oneMore = OneMoreClass(item1 = 0)
    println("Item 1: ${oneMore.item1} and Item 2: ${oneMore.item2}")
}