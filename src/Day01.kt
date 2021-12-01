fun main() {
    fun part1(input: List<Int>): Int {
        var i = 0;
        var previousMeasure: Int = Int.MAX_VALUE;
        for (measure: Int in input) {
            if (measure > previousMeasure) {
                i += 1
            }
            previousMeasure = measure
        }
        return i
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day01")
    println(part1(input.map { it.toInt()}))

}
