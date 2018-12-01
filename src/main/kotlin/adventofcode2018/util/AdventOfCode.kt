package adventofcode2018.util

import java.nio.file.Path
import java.nio.file.Paths

fun path(fileName: String): Path? {
    return Paths.get("inputs",fileName)
}