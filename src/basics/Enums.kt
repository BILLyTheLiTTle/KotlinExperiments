package basics

/* PARADIGM 3
 In case I import something from Kotlin packages I could import anything apart from classes.
 I could import public functions are variables.
 Here I import the constant values of the Planet class
 */
import basics.Planet.*
/**
 * Created by Tsapalos on 29/06/17.
 * Those examples are stolen from Java!
 * https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 */

/* PARADIGM 1
 Simple enum class example
 */
enum class Day{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

/* PARADIGM 2
 Complicated enum class example
 */
enum class Planet (val mass: Double, val radius: Double) {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7); // The only position a semicolon truly needed!

    private val g: Double = 6.67300e-11 //Java has this as static but static variable declaration is in another package

    fun surfaceGravity() = g * mass / (radius * radius)

    fun surfaceWeight(otherMass: Double): Double = otherMass * surfaceGravity()
}

/* PARADIGM 4
 Use the enum class Day to show the "when" expression in action with enums!
*/
fun showFeelingsOfTheDay (today: Day)=
    when (today) {
        Day.MONDAY -> "Thanks God, I will go to work again"
        Day.TUESDAY, Day.WEDNESDAY -> "I miss Monday so much"
        Day.THURSDAY -> "One more day to have a boring weekend"
        Day.FRIDAY -> "What an productive week!"
        Day.SATURDAY -> "What to do with my life now?"
        Day.SUNDAY -> "Finally, 24 hours left for the Monday!"
    }

/* PARADIGM 5
 Using "when" with arbitrary objects
 */
fun showMixedFeelings (day1: Day, day2: Day) =
        when (setOf(day1, day2)) {
            setOf(Day.SATURDAY, Day.SUNDAY) -> "I don't need these 2 days"
            else -> "At least we are going to work"
        }

/* PARADIGM 6
 "When" without argument
*/
fun showRealFeelingsOfTheDay (today: Day): String {
    val feeling = when {
        (today == Day.MONDAY) -> "Thanks God, I will go to work again"
        (today ==Day.TUESDAY) || (today == Day.WEDNESDAY) -> "I miss Monday so much"
        (today == Day.THURSDAY) -> "One more day to have a boring weekend"
        (today == Day.FRIDAY) -> "What an productive week!"
        (today == Day.SATURDAY) -> "What to do with my life now?"
        (today == Day.SUNDAY) -> "Finally, 24 hours left for the Monday!"
        else -> "Let me work all day long"
    }
    return feeling+"\nBoss is still watching me, guys!"
}


fun main(args: Array<String>){
    // PARADIGM 1
    println("PARADIGM 1")
    val myFavoriteDay = Day.MONDAY
    if(myFavoriteDay == Day.MONDAY){
        println("Really? Are you human?")
    }

    // PARADIGM 2, 3
    println("\nPARADIGM 2, 3")
    val myEarthWeight = 82.0 // Thanks Kotlin for keeping my weight immutable (it is val, remember?)! You are so kind!
    val mass = myEarthWeight / EARTH.surfaceGravity()
    println("My weight in Mars is: ${MARS.surfaceWeight(mass)}")

    // PARADIGM 4
    println("\nPARADIGM 4")
    println(showFeelingsOfTheDay(Day.WEDNESDAY))

    // PARADIGM 5
    println("\nPARADIGM 5")
    println(showMixedFeelings(Day.SUNDAY, Day.SATURDAY))

    // PARADIGM 6
    println("\nPARADIGM 6")
    println(showRealFeelingsOfTheDay(Day.SUNDAY))
}