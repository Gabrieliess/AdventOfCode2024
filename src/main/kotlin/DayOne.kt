import java.io.File
import kotlin.math.abs

fun main() {

    val filePath = "src/main/kotlin/dayOneData.txt"
    val loadedData = File(filePath).readLines()

    val firstRow = mutableListOf<Long>()
    val secondRow = mutableListOf<Long>()

    var combinedDistances: Long = 0

    loadedData.forEach { line ->
        val slicedData = line.split("   ")
        firstRow.add(slicedData[0].toLong())
        secondRow.add(slicedData[1].toLong())
    }

    firstRow.sort()
    secondRow.sort()

    var x = firstRow.size

    while (x > 0) {
        x--
        combinedDistances += abs(firstRow[x] - secondRow[x])
    }

    println(combinedDistances)
}