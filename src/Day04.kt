fun main() {

    fun getWinningRows(input: List<String>): List<List<Int>> {
        val winningRows = mutableListOf<List<Int>>()
        val sizeOfMatrix = input[2].replace("  ", " ").trim().split(" ").map { it.toInt() }.count()

        for (i in 2..6) {
            val row = input[i].replace("  ", " ").trim().split(" ").map { it.toInt() }
            winningRows.add(row)
        }
        val winningRowsVertical = mutableListOf<List<Int>>()
        for (n in 0 until sizeOfMatrix) {
            val row = mutableListOf<Int>()
            for (i in 0 until sizeOfMatrix) {
                row.add(winningRows[i][n])
            }
            winningRowsVertical.add(row)
        }
        val crossRowTopBottom = mutableListOf<Int>()
        for (i in 0 until sizeOfMatrix) {
            crossRowTopBottom.add(winningRows[i][i])
        }
        val crossRowBottomTop = mutableListOf<Int>()
        var backOrder = sizeOfMatrix - 1
        for (i in 0 until sizeOfMatrix) {
            crossRowBottomTop.add(winningRows[i][backOrder])
            backOrder -= 1
        }
        val winningRowsTotal = mutableListOf<List<Int>>()
        winningRowsTotal.addAll(winningRows)
        winningRowsTotal.addAll(winningRowsVertical)
        winningRowsTotal.add(crossRowTopBottom)
        winningRowsTotal.add(crossRowBottomTop)

        return winningRowsTotal
    }

    fun part1(input: List<String>): Int {
        val drawnNumbers = input[0].split(",").map { it.toInt() }
        val winningRows = getWinningRows(input)

        return winningRows.count()
    }

    fun part2(input: List<String>): Int {
        return 0
    }


    val inputTest = readInput("Day04_test")
    val input = readInput("Day04")
    println(part1(inputTest))
    println(part1(input))
    println(part2(inputTest))
    println(part2(input))

    class BingoCard(
        val cardValue: Int,
        val isChecked: Boolean
    )


}
