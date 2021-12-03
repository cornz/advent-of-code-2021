import java.util.*

fun main() {

    fun getMostUsedCharOfIndexOfLine(input: List<String>, index: Int): String {
        val arrayList = arrayListOf<Char>()
        for (row: String in input) {
            arrayList.add(row[index])
        }
        val countOfZeros = arrayList.count { it.equals("0".get(0)) }
        val countOfOnes = arrayList.count { it.equals("1".get(0)) }
        return if (countOfZeros > countOfOnes) {
            "0"
        } else {
            "1"
        }
    }

    fun part1(input: List<String>): Int {
        var bitSequence = ""
        var gamma = 0
        var epsilon = 0
        for (i in 0 until input[0].length) {
            bitSequence += getMostUsedCharOfIndexOfLine(input, i)
        }
        val bitSequenceInversed = bitSequence.replace("0", "#").replace("1", "0").replace("#", "1")

        gamma = Integer.parseInt(bitSequence,2)
        epsilon = Integer.parseInt(bitSequenceInversed, 2)

        return  gamma*epsilon

    }

    fun part2(input: List<String>): Int {
        return 0
    }


    val inputTest = readInput("Day03_test")
    val input = readInput("Day03")
    println(part1(inputTest))
    println(part1(input))
    println(part2(inputTest))
    println(part2(input))

}
