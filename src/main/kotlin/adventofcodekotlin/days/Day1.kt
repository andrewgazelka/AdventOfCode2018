package adventofcodekotlin.days

import adventofcodekotlin.util.path
import java.math.BigInteger
import java.nio.file.Files

fun main(args: Array<String>) {
    one()
    two()
}

val inputs by lazy {
    Files
        .readAllLines(path("day1.txt"))
        .map { it.toBigInteger() }
}

fun one() {
    val result = inputs.sumBy { it.toInt() }
    println("(1.1) Answer: $result")
}

fun two() {

    val freqSet = HashSet<BigInteger>()

    var sum = BigInteger.ZERO

    freqSet.add(sum)

    repeat(1000)
    {
        for (bigInteger in inputs) {
            sum += bigInteger

            if (!freqSet.add(sum)) {
                println("(1.2) Answer: $sum, Repeat #: $it")
                return
            }
        }
    }
}