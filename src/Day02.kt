fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontal = 0
        for (row: String in input) {
            val action = row.split(" ")[0]
            val value = row.split(" ")[1].toInt()
            when (action) {
                "forward" -> {
                    horizontal += value
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

    fun part2(input: List<String>): Int {
        var depth = 0
        var horizontal = 0
        var aim = 0
        for (row: String in input) {
            val action = row.split(" ")[0]
            val value = row.split(" ")[1].toInt()
            when (action) {
                "forward" -> {
                    horizontal += value
                    depth += aim * value
                }
                "down" -> {
                    aim += value
                }
                "up" -> {
                    aim -= value
                }
            }
        }
        return depth*horizontal
    }

    val inputTest = readInput("Day02_test")
    val input = readInput("Day02")
    println(part2(inputTest))
    println(part2(input))

}
