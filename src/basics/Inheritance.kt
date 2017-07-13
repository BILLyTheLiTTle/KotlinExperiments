package basics

/**
 * Created by Tsapalos on 30/06/17.
 */

//TODO explain 2.3.5 pg 46

/* PARADIGM 1
 Declare an interface and methods in it. Some methods (walk and run) have a default implementation
 */
interface Motion {
    fun walk() = println("I am walking")
    fun stand()
    fun run() = println("I am running")
}
/* PARADIGM 2
 Declare a class (Animal) that inherit from the previous interface. Also, "override" keyword is mandatory.
 As the "Kotlin in Action" sais:
 "This saves you from accidentally overriding a method if it’s added after you wrote your implementation;
 your code won’t compile unless you explicitly mark the method as override or rename it".
 Uncomment the line below and you will see the compile-time error!
 */
class Animal : Motion {
    override fun walk() {
        super.walk()
        println("I am walking cuz I am an animal")
    }

    override fun stand() {
        println("I am standing cuz I am an animal")
    }

    // PARADIGM 2
    //fun run() = println("I am running cuz I am an animal")
}

fun main(args: Array<String>){
    //PARADIGM 2
    println("PARADIGM 2")
    val animal = Animal()
    animal.walk()



}