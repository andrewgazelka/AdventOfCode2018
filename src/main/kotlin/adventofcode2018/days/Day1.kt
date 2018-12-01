package adventofcode2018.days

import adventofcode2018.util.path
import java.math.BigInteger
import java.nio.file.Files

fun main(args: Array<String>) {
    println("P1: ${one()}, P2: ${two()}")
}

val inputs by lazy {
    Files
        .readAllLines(path("day1.txt"))
        .map { it.toBigInteger() }
}

fun one(): BigInteger {
    return inputs.reduce { a, b -> a + b }
}

fun two(): BigInteger? {

    val freqSet = HashSet<BigInteger>()
    var sum = BigInteger.ZERO
    freqSet.add(sum)

    repeat(1000)
    {
        for (bigInteger in inputs) {
            sum += bigInteger

            if (!freqSet.add(sum)) {
                return sum
            }
        }
    }
    return null
}