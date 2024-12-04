package day3
import java.io.File

const val filePath = "src/main/kotlin/day3/dayThreeData.txt"
fun main() {
    val loadedData = File(filePath).readText()
    var outputData: Long = 0

    val regexPattern = Regex("mul\\(\\d+,\\d+\\)")

    val filteredData = regexPattern.findAll(loadedData)

    filteredData.forEach { match->
        val slicedData = match.value.substring(startIndex = 4, endIndex = match.value.length-1).split(',')
        outputData += slicedData[0].toInt() * slicedData[1].toInt()
    }

    println(outputData)
}