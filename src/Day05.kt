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
            //grid[fromY][fromX] = grid[fromY][fromX]+1
            //grid[toY][toX] = grid[toY][toX]+1
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
        return 0
    }


    val inputTest = readInput("Day05_test")
    val input = readInput("Day05")
    println(part1(inputTest))
    println(part1(input))
    //println(part2(inputTest))
    //println(part2(input))

}



