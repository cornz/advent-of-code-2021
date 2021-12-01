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

    fun part2(input: List<Int>): Int {
        var i = 0;
        var previousMeasureSum: Int = Int.MAX_VALUE;
        val summedWindow = input.windowed(size = 3, step = 1, partialWindows = true) { window -> window.sum() }
        for (window: Int in summedWindow) {
            if (window > previousMeasureSum) {
                i += 1
            }
            previousMeasureSum = window
        }
        return i
    }

    val input = readInput("Day01")
    val input_test = readInput("Day01")
    // println(part1(input.map { it.toInt()}))
    println(part2(input_test.map { it.toInt()}))

}
