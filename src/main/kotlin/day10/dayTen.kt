package day10

import java.io.File

const val filePath = "src/main/kotlin/day10/dayTenData.txt"
val visitedEnds = mutableListOf<Set<Int>>()
var trailHeadCounter = 0
fun pathFinder(x: Int, y: Int, height: Int, map: List<CharArray>): Boolean {
    var possiblePaths = mutableListOf<Int?>()

    try {
        possiblePaths.add(map[y - 1][x].toString().toIntOrNull())
    } catch (problemo: Exception) {
        possiblePaths.add(null)
        println(problemo)
    }
    try {
        possiblePaths.add(map[y][x + 1].toString().toIntOrNull())
    } catch (problemo: Exception) {
        possiblePaths.add(null)
        println(problemo)
    }
    try {
        possiblePaths.add(map[y + 1][x].toString().toIntOrNull())
    } catch (problemo: Exception) {
        possiblePaths.add(null)
        println(problemo)
    }
    try {
        possiblePaths.add(map[y][x - 1].toString().toIntOrNull())
    } catch (problemo: Exception) {
        possiblePaths.add(null)
        println(problemo)
    }

    possiblePaths.filter { it == height + 1 }

    if (height == 9) { //bottom
        if (!visitedEnds.contains(setOf(x, y))) {
            visitedEnds.add(setOf(x, y))
            trailHeadCounter++
            return true
        } else {
            return false
        }
    }

    var counter = 0
    possiblePaths.forEach {
        if (counter == 0 && possiblePaths[0] != null) {
            if (pathFinder(x, y - 1, height + 1, map)) {
                return true
            }
        } else if (counter == 1 && possiblePaths[1] != null) {
            if (pathFinder(x + 1, y, height + 1, map)) {
                return true
            }
        } else if (counter == 2 && possiblePaths[2] != null) {
            if (pathFinder(x, y + 1, height + 1, map)) {
                return true
            }
        } else if (counter == 3 && possiblePaths[3] != null) {
            if (pathFinder(x - 1, y, height + 1, map)) {
                return true
            }
        }
        counter++
    }


    return false
}

fun main() {
    val loadedData = File(filePath).readLines()
    val mapLayout = loadedData.map { it.toCharArray() }
    var y = 0

    loadedData.forEach { strip ->
        var x = 0
        strip.forEach { char ->
            if (char == '0') {
                pathFinder(x, y, 0, mapLayout)
            }
            x++

        }
        y++
    }
    println(trailHeadCounter)
}

