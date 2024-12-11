import java.io.File

private const val filePath = "src/main/kotlin/day7/daySevenData.txt"
val numSet = mutableListOf<List<Long>>()
var roots = mutableListOf<Long>()

fun rootFinder(value: Long, index: Int, listIndex: Int): Boolean {
    if (index == numSet[listIndex].size) {
        return value == roots[listIndex]
    }
    if (rootFinder(value + numSet[listIndex][index], index + 1, listIndex)) {
        return true
    }
    if (rootFinder(value * numSet[listIndex][index], index + 1, listIndex)) {
        return true
    }
    return false
}

fun main() {
    val loadedData = File(filePath).readLines()
    var counter = 0
    var rootSum: Long = 0

    loadedData.forEach { line ->
        roots += line.substringBefore(':').toLong()
        numSet.add(line.substringAfter(": ").split(' ').map { it.toLong() })
    }

    roots.forEach { root ->
        if (rootFinder(numSet[counter][0], 1, counter)) {
            rootSum += root
        }
        counter++
    }
    println(rootSum)
}
