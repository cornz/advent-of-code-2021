import java.lang.Math.*

fun main() {


    fun part1(input: List<String>): Int {
        val grid = input.map { it.toCharArray().map { it - '0' } }

        var risk = 0
        val height = grid.size
        val width = grid[0].size

        for (y in 0 until height) for (x in 0 until width) {
            val point = grid[y][x]

            if (x + 1 < width && grid[y][x + 1] <= point) {
                continue
            }
            if (x - 1 >= 0 && grid[y][x - 1] <= point)  {
                continue
            }
            if (y + 1 < height && grid[y + 1][x] <= point) {
                continue
            }
            if (y - 1 >= 0 && grid[y - 1][x] <= point) {
                continue
            }

            risk += point + 1
        }

        return risk
    }

    fun part2(input: List<String>): Int {

        return 0
    }


    val inputTest = readInput("Day09_test")
    val input = readInput("Day09")
    println(part1(inputTest))
    println(part1(input))
    println(part2(inputTest))
    println(part2(input))


}



