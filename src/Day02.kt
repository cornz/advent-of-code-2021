fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontal = 0
        for (row: String in input) {
            val action: String = row.split(" ")[0]
            val value: Int = row.split(" ")[1].toInt()
            when (action) {
                "forward" -> {
                    horizontal += value;
                }
                "down" -> {
                    depth += value
                }
                "up" -> {
                    depth -= value
                }
            }
        }
        return depth*horizontal
    }

    fun part2(input: List<Int>): Int {

        return i
    }

    val input = readInput("Day02_Test")
    val input_test = readInput("Day02")
    // println(part1(input.map { it.toInt()}))
    println(part1(input_test))

}
