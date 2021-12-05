import java.lang.Math.abs
import java.lang.Math.max
import kotlin.math.roundToInt

fun main() {

    fun countOccurrencesOverOne(grid: Array<Array<Int>>): Int {
        var ret = 0
        for (row: Array<Int> in grid) {
            for (item: Int in row) {
                if (item > 1) {
                    ret += 1
                }
            }
        }
        return ret
    }

    fun findMaxNumberInInput(input: List<String>): Int {
        var maxNumber = 0
        for (row: String in input) {
            val fromTo = row.split(" -> ")
            val fromX = fromTo[0].split(",")[0].toInt()
            val fromY = fromTo[0].split(",")[1].toInt()
            val toX = fromTo[1].split(",")[0].toInt()
            val toY = fromTo[1].split(",")[1].toInt()
            val localMax = listOf<Int>(fromX, toX, fromY, toY).maxOrNull() ?: 0
            if (localMax > maxNumber) {
                maxNumber = localMax
            }
        }
        return maxNumber+1
    }

    fun part1(input: List<String>): Int {
        val maxNumber = findMaxNumberInInput(input)
        val grid = Array(maxNumber) {
            Array(maxNumber) {
                0
            }
        }
        for (row: String in input) {
            val fromTo = row.split(" -> ")
            val fromX = fromTo[0].split(",")[0].toInt()
            val fromY = fromTo[0].split(",")[1].toInt()
            val toX = fromTo[1].split(",")[0].toInt()
            val toY = fromTo[1].split(",")[1].toInt()
            if (fromX == toX) {
                if (fromY > toY) {
                    for (i in toY .. fromY) {
                        grid[i][fromX] = grid[i][toX]+1
                    }
                } else {
                    for (i in fromY .. toY) {
                        grid[i][fromX] = grid[i][toX]+1
                    }
                }
            } else if (fromY == toY) {
                if (fromX > toX) {
                    for (i in toX .. fromX) {
                        grid[fromY][i] = grid[fromY][i]+1
                    }
                } else {
                    for (i in fromX..toX) {
                        grid[fromY][i] = grid[fromY][i] + 1
                    }
                }
            }
        }
        print(grid.joinToString("\n") { it.joinToString("")})
        println("\n")
      return countOccurrencesOverOne(grid)
    }

    fun part2(input: List<String>): Int {
        val maxNumber = findMaxNumberInInput(input)
        val grid = Array(maxNumber) {
            Array(maxNumber) {
                0
            }
        }
        for (row: String in input) {
            val fromTo = row.split(" -> ")
            val fromX = fromTo[0].split(",")[0].toInt()
            val fromY = fromTo[0].split(",")[1].toInt()
            val toX = fromTo[1].split(",")[0].toInt()
            val toY = fromTo[1].split(",")[1].toInt()
            if (fromX == toX) {
                if (fromY > toY) {
                    for (i in toY .. fromY) {
                        grid[i][fromX] += 1
                    }
                } else {
                    for (i in fromY .. toY) {
                        grid[i][fromX] += 1
                    }
                }
            } else if (fromY == toY) {
                if (fromX > toX) {
                    for (i in toX .. fromX) {
                        grid[fromY][i] += 1
                    }
                } else {
                    for (i in fromX..toX) {
                        grid[fromY][i] += 1
                    }
                }
            } else {
                val deltaX = toX - fromX
                val deltaY = toY - fromY
                val maximum = kotlin.math.abs(deltaX).coerceAtLeast(kotlin.math.abs(deltaY))
                for (i in 0..maximum) {
                    val x = i/maximum.toDouble() * deltaX + fromX
                    val y = i/maximum.toDouble() * deltaY + fromY
                    grid[x.roundToInt()][y.roundToInt()] += 1
                }
            }
        }
        print(grid.joinToString("\n") { it.joinToString("")})
        println("\n")
        return countOccurrencesOverOne(grid)
    }


    val inputTest = readInput("Day05_test")
    val input = readInput("Day05")
    println(part1(inputTest))
    println(part1(input))
    println(part2(inputTest))
    println(part2(input))

}



