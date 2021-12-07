import java.lang.Math.*

fun main() {

    fun part1(input: List<String>): Int {
        val ints = input[0].split(",").map { it.toInt() }
        val maximum = ints.maxOrNull()?: 0
        val minimum = ints.minOrNull()?: 0
        var fuel = Int.MAX_VALUE
        for (i in minimum..maximum) {
            val diff = ints.sumOf { x -> kotlin.math.abs(i - x) }
            if (diff < fuel) {
                fuel = diff
            }
        }
       return fuel
    }

    fun part2(input: List<String>): Long {
        val ints = input[0].split(",").map { it.toInt() }
        val maximum = ints.maxOrNull()?: 0
        val minimum = ints.minOrNull()?: 0
        var fuel = Long.MAX_VALUE
        for (i in minimum..maximum) {
            val diff = ints.sumOf {
                    x ->
                val originalDiff = kotlin.math.abs(i - x)
                originalDiff.toLong() * (originalDiff + 1) / 2
            }
            if (diff < fuel) {
                fuel = diff
            }
        }
        return fuel
    }


    val inputTest = readInput("Day07_test")
    val input = readInput("Day07")
    println(part1(inputTest))
    println(part1(input))
    println(part2(inputTest))
    println(part2(input))


}



