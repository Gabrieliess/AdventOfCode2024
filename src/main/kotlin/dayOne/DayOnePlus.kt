package dayOne

import java.io.File

fun main() {

    val filePath = "src/main/kotlin/dayOne/dayOneData.txt"
    val loadedData = File(filePath).readLines()

    val firstRow = mutableListOf<Long>()
    val secondRow = mutableListOf<Long>()

    var similarityScore: Long = 0

    loadedData.forEach { line ->    // data splitter
        val slicedData = line.split("   ")
        firstRow.add(slicedData[0].toLong())
        secondRow.add(slicedData[1].toLong())
    }

    firstRow.forEach { number ->
        var duplicates: Int = 0

        secondRow.forEach {
            if (number == it) {
                duplicates++
            }
        }
        similarityScore += number * duplicates
    }

    println(similarityScore)
}














