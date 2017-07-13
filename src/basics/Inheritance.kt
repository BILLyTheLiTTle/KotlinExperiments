package basics

/**
 * Created by Tsapalos on 30/06/17.
 */

//TODO explain 2.3.5 pg 46

/* PARADIGM 1 - no need to run something in main function
 Declare an interface and methods (abstract and non-abstract) in it.
 Some methods (walk and run) have a default implementation
 */
interface Motion {
    fun walk()
    fun stand() = println("I am standing")
    fun run() = println("I am running")
}

/* PARADIGM 3
 Declare an interface with a method
 */
interface Survival {
    fun stand() = println("Standing still and not breathing")
}
/* PARADIGM 2
 Declare a class (Animal) that inherit from the previous interface. Also, "override" keyword is mandatory.
 As the "Kotlin in Action" sais:
 "This saves you from accidentally overriding a method if it’s added after you wrote your implementation;
 your code won’t compile unless you explicitly mark the method as override or rename it".
 Uncomment the line at the run function below and you will see the compile-time error!

 PARADIGM 3
 Inherit from another interface also. Doing it we have a problem in calling the stand method from an interface.
 See the declaration of stand method to find out how this is done.
 */
class Animal : Motion, Survival {
    override fun walk() {
        println("I am walking cuz I am an animal")
    }

    override fun stand() {
        super<Motion>.stand()
        super<Survival>.stand()
        println("I am standing cuz I am an animal")
    }

    // PARADIGM 2
    //fun run() = println("I am running cuz I am an animal")
}

fun main(args: Array<String>){
    // PARADIGM 2
    println("PARADIGM 2")
    val animal = Animal()
    animal.walk()

    // PARADIGM 3
    println("\nPARADIGM 3")
    animal.stand()

}