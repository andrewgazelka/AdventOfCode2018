package com.andrewgazelka.adventofcode2018.days

import com.andrewgazelka.adventofcode2018.util.path
import java.nio.file.Files

fun main(args: Array<String>) {
    val input by lazy { Files.readAllLines(path("day2.txt")) }

    fun String.findRepeatSet(): Collection<Int> {
        return this.groupingBy { it }
            .eachCount()
            .values
    }

    fun one(): Int {
        val map1 = input.map { it.findRepeatSet() }
        return map1.count { it.contains(2) } * map1.count { it.contains(3) }
    }


    fun two() {
        input
            .asSequence()
            .mapIndexed { i, outer ->
                input.asSequence().drop(i).mapNotNull { inner ->
                    val diff = outer.diffIndexes(inner)
                    if (diff.size == 1) {
                        outer.removeAt(diff.first())
                    } else {
                        null
                    }
                }
            }
            .flatten()
            .first()
    }
}

private fun String.removeAt(first: Int) = this.substring(0,first) + this.substring(first+1)


private fun String.diffIndexes(inner: String) =
    this.mapIndexed { index, c -> if (inner[index] == c) index else null }
        .filterNotNull()

