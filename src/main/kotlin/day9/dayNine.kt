package day9

import java.io.File
import java.util.Collections

const val filePath = "src/main/kotlin/day9/dayNineData.txt"
var checkSum:Long = 0
fun main() {
    val loadedData = File(filePath).readText()
    var modifiedData = mutableListOf<String>()
    var counter = 0

    loadedData.forEach { number ->
        for (i in 1..number.digitToInt()) {
            if (counter % 2 == 0) {
                modifiedData += ("$counter")
            } else if (counter % 2 == 1) {
                modifiedData += ("")
            }
        }
        counter++
    }

    for (i in 1..modifiedData.count { it.isEmpty() }){      // like 13,000ms runtime god help me
        Collections.swap(modifiedData, modifiedData.indexOf(""), modifiedData.indexOfLast { it.isNotEmpty() })
    }

    counter = 0
    modifiedData.filter { it.isNotEmpty() }
    modifiedData.forEach { number ->
        if(number.isNotEmpty()){
            checkSum += counter * number.toLong()
        }
        counter++
    }
    println(checkSum/2)
}