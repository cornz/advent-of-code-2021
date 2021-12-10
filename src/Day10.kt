import java.lang.Math.*

fun main() {


    fun part1(input: List<String>): Int {
        val opening = listOf("[", "(", "{", "<")
        val closing = listOf("]", ")", "}", ">")
        val illegalPoints = hashMapOf(
            ")" to 3,
            "]" to 57,
            "}" to 1197,
            ">" to 25137
        )

        var ret = 0

        for (row: List<String> in input.map { it -> it.toCharArray().map { it.toString() } }) {
            val openedChars = mutableListOf<String>()
            for (char: String in row) {
                if (opening.contains(char)) {
                    openedChars.add(char)
                } else {
                    val correspondingOpeningChar = opening[closing.indexOf(char)]
                    if (correspondingOpeningChar != openedChars.last()) {
                        println("ERROR: " + char)
                        println(row)
                        openedChars.clear()
                        ret += illegalPoints[char]!!
                        break
                    } else {
                        openedChars.removeLast()
                    }
                }
            }
        }
        return ret
    }

    fun part2(input: List<String>): Int {

        return 0
    }


    val inputTest = readInput("Day10_test")
    val input = readInput("Day10")
    println(part1(inputTest))
    println(part1(input))
    //println(part2(inputTest))
    //println(part2(input))

}



