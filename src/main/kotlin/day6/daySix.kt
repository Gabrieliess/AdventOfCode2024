package day6

import java.io.File
import java.lang.Exception

const val filePath = "src/main/kotlin/day6/daySixData.txt"
var mapLayout = File(filePath).readLines().toMutableList()
var posY = mapLayout.indexOfFirst { it.contains('^') }
var posX = mapLayout[posY].indexOf('^')
var stepCount = 0
var direction = 1 // 1-up, 2-right, 3-down, 4-left

fun validateMove(x: Int, y: Int): Boolean {
    if (posY + y in 0..<mapLayout.size && posX + x in 0..<mapLayout[0].length) { // we can move
        return true
    } else {
        mapLayout[posY] = mapLayout[posY].toCharArray().also { it[posX] = 'X' }.concatToString()
        stepCount++
        return false
    }
}

fun move(x: Int, y: Int) {
    mapLayout[posY] = mapLayout[posY].toCharArray().also { it[posX] = 'X' }.concatToString() // for debugging


    if (mapLayout[posY + y][posX + x] != '#') { // we are clear to move
        posY += y
        posX += x
        if (mapLayout[posY][posX] == '.') {
            stepCount++
        }
    } else if (mapLayout[posY + y][posX + x] == '#') { // turning
        direction = (direction % 4) + 1
    }
}

fun main() {

    while (true) {
        when (direction) {
            1 -> {
                if (validateMove(0, -1)) {
                    move(0, -1)
                } else {
                    break
                }
            }

            2 -> {
                if (validateMove(1, 0)) {
                    move(1, 0)
                } else {
                    break
                }
            }

            3 -> {
                if (validateMove(0, 1)) {
                    move(0, 1)
                } else {
                    break
                }
            }

            4 -> {
                if (validateMove(-1, 0)) {
                    move(-1, 0)
                } else {
                    break
                }
            }
        }
        println("$posX;$posY")
    }

    mapLayout.forEach { println(it) }
    println(stepCount)
}


