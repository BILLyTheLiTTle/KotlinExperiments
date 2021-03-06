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

/* PARADIGM 7
 Call another constructor from the same class (using "this") and do an extra job also
 */
class AClass {

    val value1: Int
    val value2: Int
    var value3 = -1
    constructor(value: Int): this(value, -1){
        value3 = 3
    }

    constructor(value1: Int, value2: Int) {
        this.value1 = value1
        this. value2 = value2
    }
}

/* PARADIGM 8
 Change the visibility of the accessor methods
 */
class BClass {
    var item1 = -1
    private set

    fun setFirstItem(value: Int) {
        item1 = value
    }
    }

/* PARADIGM 9
 The data classes.

 Instead of autogenerate the toString, equals, hashcode method use the "data" modifier.
 All these functions will be generated without adding source code to your code.

 PITFALL: Properties that are not declared in the primary constructor don't take part in the equality checks
 and hashcode calculation.

 PARADIGM 11
 Explain the above pitfall using equality check
 */
class NoDataClass(val aString: String, val anInt: Int)

data class DataClass(val aString: String, val anInt: Int) {
    var anotherString:String = ""
}

/* PARADIGM 10
 Equality and reference equality

 equals: Check if two objects are equal
 ==: Check if two objects are equal. "Equals" function is invoked
 ===: Check for reference equality
 */
data class Equalizer(val lastname: String, val firstName: String)

/* PARADIGM 12
 Kotlin compiler generates also a "copy" function for data classes.
 There is no need to create a new class. I will use DataClass instead.
 */

fun main(args: Array<String>){
    // PARADIGM 1
    println("PARADIGM 1")
    val person = Person("Bill", 31)
    println("This is ${person.name} and he is ${person.age} years old")

    // PARADIGM 2
    println("\nPARADIGM 2")
    val girl = Woman("Sissy")
    girl.age = 24
    println("My name is ${girl.name} and I am ${girl.age} years old") // It's a woman! She will not tell you her age!

    // PARADIGM 3
    println("\nPARADIGM 3")
    val someClass = SomeClass("SomeClass Item")
    println("${someClass.item}")
    println("${someClass.item1}")

    // PARADIGM 6
    println("\nPARADIGM 6")
    val oneMore = OneMoreClass(item1 = 0)
    println("Item 1: ${oneMore.item1} and Item 2: ${oneMore.item2}")

    // PARADIGM 7
    println("\nPARADIGM 7")
    val aClass = AClass(1)
    println("Value 1: ${aClass.value1}, Value 2: ${aClass.value2} and Value 3: ${aClass.value3}")

    // PARADIGM 8
    println("\nPARADIGM 8")
    val bClass = BClass()
    //bClass.item1 = 1
    bClass.setFirstItem(1)
    println("Item 1: ${bClass.item1}")

    // PARADIGM 9
    println("\nPARADIGM 9")
    println("\ntoString() function difference")
    val noDataClass = NoDataClass("No Data", 1)
    val dataClass = DataClass("No Data", 1)
    println("No Data Class: ${noDataClass.toString()}\nData Class: ${dataClass.toString()}")
    println("\nequals() function difference")
    val noDataClass1 = NoDataClass("No Data", 1)
    val dataClass1 = DataClass("No Data", 1)
    println("No Data Classes are equals: ${noDataClass.equals(noDataClass1)}\n" +
            "Data Classes are equals: ${dataClass.equals(dataClass1)}")
    println("\nhashcode() function difference")
    println("Hashcode of No Data Class: ${noDataClass.hashCode()}")
    println("Hashcode of No Data Class 1: ${noDataClass1.hashCode()}")
    println("Hashcode of Data Class: ${dataClass.hashCode()}")
    println("Hashcode of Data Class 1: ${dataClass1.hashCode()}")

    // PARADIGM 10
    println("\nPARADIGM 10")
    val robert = Equalizer("McCall", "Robert")
    val denzel = robert
    val me = Equalizer("McCall", "Robert")
    println("Compare robert and denzel using equals: ${robert.equals(denzel)}")
    println("Compare robert and denzel using ==: ${robert == denzel}")
    println("Compare robert and denzel using ===: ${robert === denzel}")
    println("Compare robert and me using equals: ${robert.equals(me)}")
    println("Compare robert and me using ==: ${robert == me}")
    println("Compare robert and me using ===: ${robert === me}")

    // PARADIGM 11
    println("\nPARADIGM 11")
    val dataClassOne = DataClass("One", 1)
    dataClassOne.anotherString = "First"
    val dataClassTwo = DataClass("One", 1)
    dataClassTwo.anotherString = "Second"
    println("dataClassOne and dataClassTwo are equals: ${dataClassOne.equals(dataClassTwo)}")

    // PARADIGM 12
    println("\nPARADIGM 12")
    val originalDataClass = DataClass("One", 1)
    val copiedDataClass = originalDataClass.copy(anInt = 2)
    println("Original Data Class: ${originalDataClass.toString()}")
    println("Copied Data Class: ${copiedDataClass.toString()}")
}