import java.lang.Math.*

fun main() {

    fun part1(input: List<String>): Int {
        var rt = 0
        for (row: String in input) {
            for (digit: String in row.split("|")[1].trim().split(" ")) {
                if (digit.length in listOf(2,3,4,7)) {
                    rt += 1
                }
            }
        }

        return rt
    }

    fun part2(input: List<String>): Int {
        return 0
    }


    val inputTest = readInput("Day08_Test")
    val input = readInput("Day08")
    println(part1(inputTest))
    println(part1(input))
    println(part2(inputTest))
    println(part2(input))


}



