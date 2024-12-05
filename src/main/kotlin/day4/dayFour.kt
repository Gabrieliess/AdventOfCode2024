package day4

import java.io.File

const val filePath = "src/main/kotlin/day4/dayFourData.txt"


fun main() {
    val loadedData = File(filePath).readLines()
    var lineNumber = 0
    var output = 0
    val validInput = setOf('X','M','A','S')

    loadedData.forEach { line ->
        val slicedLine = line.toCharArray()
        var counter = 0
        slicedLine.forEach { letter ->
            if(letter in validInput) {


                if (line.length >= counter + 4) {               // horizontal search im going insane
                    if (letter == 'X') {
                        if (line.substring(counter + 0, counter + 4) == "XMAS") {
                            output++
                        }

                    }
                    if (letter == 'S') {
                        if (line.substring(counter + 0, counter + 4) == "SAMX") {
                            output++
                        }

                    }
                }


                if (loadedData.size >= lineNumber + 4) {
                    if (letter == 'X' || letter == 'S') {
                        var verticalChunk: String = ""

                        for (n in 0..3) {             // vertical both ways lol lost in darkness of uneffectiveness
                            verticalChunk += loadedData[lineNumber + n][counter]
                        }
                        if (verticalChunk == "XMAS" || verticalChunk == "SAMX") {
                            println(verticalChunk)
                            output++
                        }
                    }
                }



                if (line.length >= counter + 5) {               // diagonal right
                    if (loadedData.size >= lineNumber + 5) {
                        var diagonalRightChunk: String = ""
                        for (n in 0..3) {
                            diagonalRightChunk += loadedData[lineNumber + n][counter + n].toChar()
                        }
                        if (diagonalRightChunk.toString() == "XMAS" || diagonalRightChunk.toString() == "SAMX") {
                            output++
                            println("------$diagonalRightChunk")
                        }
                    }
                }

                if (counter >= 5) {                             // diagonal left
                    if (loadedData.size >= lineNumber + 5) {
                        var diagonalLeftChunk: String = ""

                        for (m in 0..3) {
                            diagonalLeftChunk += loadedData[lineNumber + m][counter - m].toChar()
                        }
                        if (diagonalLeftChunk.toString() == "XMAS" || diagonalLeftChunk.toString() == "SAMX") {
                            output++
                            println("---------$diagonalLeftChunk")
                        }
                    }
                }
            }

            counter++
        }

        lineNumber++

        /*-----------*/
        println(output)
        /*-----------*/
    }
}

// 2565 is too much, 1349 is too low