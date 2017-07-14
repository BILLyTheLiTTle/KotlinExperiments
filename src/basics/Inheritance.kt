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

 PARADIGM 4 - no need to run something in main function
 What is a final method? What is an open method? Can a method be final and override inside an open class?
 Make my mind hurt!

 open: A class or method with this modifier is allowed to have subclasses or get overriden.
 final: A class or method with this modifier cannot have subclasses or get overriden.
            All classes in Kotlin are final by default. Read "Effective Java" if you want to find out why.
 override: Just declare that you override a method from an open class or interface.
            Overriden methods are open by default

 Uncomment the stand function at Dog class and see the compile-time error
 */
open class Animal : Motion, Survival {
    override fun walk() {
        println("I am walking cuz I am an animal")
    }

    final override fun stand() {
        super<Motion>.stand()
        super<Survival>.stand()
        println("I am standing cuz I am an animal")
    }

    // PARADIGM 2
    //fun run() = println("I am running cuz I am an animal")
}

class Dog : Animal(){
    override fun walk() {
        super.walk()
        println("I am walking as a Dog")
    }

    // PARADIGM 4
    //override fun stand(){}
}

/* PARADIGM 5 - no need to run something in main function
 Declare an abstract class. Methods in abstract classes cannot be overriden unless they have abstract or open modifier
 */
abstract class Felidae {
    abstract fun walk()
    open fun eat(){
        println("I am eating like a Felidae")
    }
    fun run() = println("I am ruuning cuz I am a Felidae")
}
class Cat : Felidae() {
    override fun walk() {
        println("I am walking like a Cat")
    }

    override fun eat() {
        super.eat()
        println("I am eating like a Cat")
    }
}

/* PARADIGM 6 - no need to run something in main function
 Presenting the visibility modifiers

 public: Let everyone know!
 internal: Let's keep it secret inside the module, right?!
 protected: It's all about family, me and the subclasses will ever know!
 private: It's private. Only the class knows. Everyone else who knows, has committed suicide with 3 bullets in the head!
 */
internal open class Bird : Animal(){
    private fun fly() = println("I am flying but I don't want anyone to know about it")
    protected fun drink() = println("Let my sub-birds know that I am thirsty but don't let the tiger know about it!")
}

/* PARADIGM 7 - no need to run something in main function
 Inner and nested classes. By default they are nested. We don't want any reference to escape, do we?

 inner: stores no reference to the outer class
 nested: stores a reference to the outer class

 Uncomment the line at NestedClass and you will see!
 */
class OuterClass {
    val number = 1
    class NestedClass{
        //val nestedNumber = this@OuterClass.number
    }
    inner class InnerClass{
        val nestedNumber = this@OuterClass.number
    }
}

/* PARADIGM 8
 Sealed classes. A sealed class can have subclasses (it is open by default) but in a range.
 You cannot define in every file you want.
 You can define subclasses of a sealed class:
  - inside a block with the "sealed" modifier (Water, Whisky), or
  - in the same file (Wine)
 The true power of "sealed" modifier is hidden at the comment where I define the Coffee class.
 Uncomment this line and inspect the compile-time error at when condition in the "whatIsIt" function!
 */
sealed class Liquid {
    open fun whatAmI() = println("Liquid")
    class Water : Liquid() {
        override fun whatAmI() = println("Water")
    }
    open class Whisky : Liquid() { // you can have open classes in a sealed block
        override fun whatAmI() = println("Whisky")
    }
}
class Wine : Liquid()
//class Coffee : Liquid()
class WhiskyWithIce : Liquid.Whisky() { // inherit from a class with sealed superclass
    override fun whatAmI() = println("Whisky on the rocks")
}

fun whatIsIt(drink: Liquid) =
        when (drink) {
            is Liquid.Water -> println("It is water")
            is Liquid.Whisky -> println("It is whisky")
            is Wine -> println("It is wine")
        }

fun main(args: Array<String>){
    // PARADIGM 2
    println("PARADIGM 2")
    val animal = Animal()
    animal.walk()

    // PARADIGM 3
    println("\nPARADIGM 3")
    animal.stand()

    // PARADIGM 8
    println("\nPARADIGM 8")
    // Uncomment the line below and inspect another compile-time error (Sealed types cannot be instantiated)
    //whatIsIt(Liquid())
    whatIsIt(Liquid.Water())

}