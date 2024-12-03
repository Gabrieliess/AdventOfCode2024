package day5
import java.io.File

const val filePath = "src/main/kotlin/day5/dayFiveData.txt"

fun main() {
    val loadedData = File(filePath).readLines()
    val rules = mutableListOf<MutableList<Int>>()
    val updates = mutableListOf<MutableList<Int>>()
    val goodUpdates = mutableListOf<MutableList<Int>>()
    var pagesSum: Long = 0

    loadedData.forEach { line -> // vypluje premapovany vstup na int
        if (line.contains('|')) {
            rules.add(line.split('|').map { it.toInt() }.toMutableList())
        } else if (line.contains(',')) {
            updates.add(line.split(',').map { it.toInt() }.toMutableList())
        }
    }
    updates.forEach { updateSet ->
        var result = true
        rules.forEach { ruleSet ->
            if (updateSet.contains(ruleSet[0]) && updateSet.contains(ruleSet[1])) {
                    if (updateSet.indexOf(ruleSet[0]) > updateSet.indexOf(ruleSet[1])) { result = false }
            }
        }
        if(result){ goodUpdates.add(updateSet) }
    }
    goodUpdates.forEach { ruleSet -> pagesSum += ruleSet[(ruleSet.size - 1) / 2] }
    println(pagesSum)
}