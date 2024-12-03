package dayTwo

import java.io.File
import kotlin.math.abs

const val filePath = "src/main/kotlin/dayTwo/dayTwoData.txt"
var validData = 0

fun validateDiff(values: List<String>): Boolean {
    for (n in 0..<values.size-1) {
        val diff = abs(values[n].toInt() - values[n + 1].toInt())
        if (diff !in 1..3) {
            return false
        }
    }
    return true
}

fun validateSeq(values: List<String>): Boolean {
    if (values[0].toInt() > values[1].toInt()) {
        for (n in 0..<values.size-1) {
            if (values[n].toInt() <= values[n + 1].toInt()) {
                return false
            }
        }
    } else if (values[0].toInt() < values[1].toInt()) {
        for (n in 0..<values.size-1) {
            if (values[n].toInt() >= values[n + 1].toInt()) return false
        }
    } else {
        return false
    }
    return true
}

fun main() {

    val loadedData = File(filePath).readLines()

    loadedData.forEach { line ->
        val slicedLine = line.split(" ")

        if (validateSeq(slicedLine) && validateDiff(slicedLine)) {
            validData++
        }
    }

    println(validData)
}
