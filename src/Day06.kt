import java.lang.Math.abs
import java.lang.Math.max
import kotlin.math.roundToInt

fun main() {

    class Fish (var daysLeft: Int) {

        fun decreaseBy(decrease: Int) {
            this.daysLeft -= decrease
        }

        fun addFish(): Fish? {
            if (daysLeft == 0) {
                daysLeft = 6
                return Fish(8)
            }
            daysLeft --
            return null
        }
    }

    fun mapFish(input: List<String>): Map<Int, Long> = input[0]
        .split(',')
        .map { it.toInt() }
        .groupingBy { it }
        .eachCount()
        .mapValues { (_, entry) -> entry.toLong() }

    fun Map<Int, Long>.shiftUp() = mapOf(
        0 to getOrDefault(1, 0),
        1 to getOrDefault(2, 0),
        2 to getOrDefault(3, 0),
        3 to getOrDefault(4, 0),
        4 to getOrDefault(5, 0),
        5 to getOrDefault(6, 0),
        6 to getOrDefault(7, 0) + getOrDefault(0, 0),
        7 to getOrDefault(8, 0),
        8 to getOrDefault(0, 0)
    )



    fun part1(input: List<String>, days: Int): Long {
        val fishes = input[0].split(",").map { Fish(it.toInt()) }.toMutableList()
        repeat(days) {
            val newFishes = fishes.mapNotNull { it.addFish() }
            fishes += newFishes
        }

        return fishes.count().toLong()
    }

    fun part2(input: List<String>, days: Int): Long {
        var fishes = mapFish(input)

        repeat(256) {
            fishes = fishes.shiftUp()
        }

        return fishes.values.sum()
    }


    val inputTest = readInput("Day06_test")
    val input = readInput("Day06")
    //println(part1(inputTest, 18))
    //println(part1(inputTest, 80))
    //println(part1(input, 80))
    //println(part1(input, 250))
    println(part2(inputTest, 256))
    println(part2(input, 256))


}



