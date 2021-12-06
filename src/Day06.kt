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



    fun part1(input: List<String>, days: Int): Int {
        val fishes = input[0].split(",").map { Fish(it.toInt()) }.toMutableList()
        repeat(days) {
            val newFishes = fishes.mapNotNull { it.addFish() }
            fishes += newFishes
        }

        return fishes.count()
    }

    fun part2(input: List<String>): Int {
        return 0
    }


    val inputTest = readInput("Day06_test")
    val input = readInput("Day06")
    println(part1(inputTest, 18))
    println(part1(inputTest, 80))
    println(part1(input, 80))
    //println(part2(inputTest))
    //println(part2(input))


}



