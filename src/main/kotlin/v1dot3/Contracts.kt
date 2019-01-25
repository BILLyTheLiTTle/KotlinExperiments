package v1dot3

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/* These examples are derived more or less from here
    (https://proandroiddev.com/kotlin-contracts-make-great-deals-with-the-compiler-f524e57f11c)
 */

@ExperimentalContracts
fun main(args: Array<String>) {
    val valueShouldRunOnce: Int
    shouldRunOnce {
        valueShouldRunOnce = 2
    }
    println(valueShouldRunOnce)

    var msg = "hello"
    println(getMsgLength(msg))

    println(getMsgLength(null))
}

@ExperimentalContracts
fun shouldRunOnce(valueSet: () -> Unit) {
    // Comment - uncomment the code below
    contract { callsInPlace(valueSet, InvocationKind.EXACTLY_ONCE) }
    valueSet()
}

@ExperimentalContracts
fun String?.isItBig(): Boolean {
    // Comment - uncomment the code below
    contract { returns(true) implies (this@isItBig is String) }
    return this!=null && this.length>=5
}

@ExperimentalContracts
fun getMsgLength(msg: String?): String {
    var length = ""
    if(msg.isItBig()) {
        length = msg
    }
    return if(length.isItBig()) "Big" else "Small"
}
