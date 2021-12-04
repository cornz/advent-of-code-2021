fun main() {

    fun getWinningRows(input: List<String>): List<List<Int>> {
        val winningRows = mutableListOf<List<Int>>()
        val sizeOfMatrix = input[0].replace("  ", " ").trim().split(" ").map { it.toInt() }.count()

        for (element in input) {
            val row = element.replace("  ", " ").trim().split(" ").map { it.toInt() }
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

    fun getBoards(input: List<String>): MutableList<List<String>> {
        val boards = mutableListOf<List<String>>()
        val sublist = mutableListOf<String>()
        for (i in 2 until input.size) {
            if (input[i] != "") {
                sublist.add(input[i])
            } else {
                boards.add(sublist.toList())
                sublist.clear()
            }
        }
        return boards
    }


    fun part1(input: List<String>): Int {
        val toBeDrawnNumbers = input[0].split(",").map { it.toInt() }
        val drawnNumbers = mutableListOf<Int>()

        val boards = getBoards(input)
        val allWinningRows = mutableListOf<List<Int>>()
        for (board: List<String> in boards) {
            val winningRows = getWinningRows(board)
            allWinningRows.addAll(winningRows)
        }

        val winningBoard: List<String>
        var sum = 0
        for (number: Int in toBeDrawnNumbers) {
            drawnNumbers.add(number)
            for (list: List<Int> in allWinningRows) {
                if (drawnNumbers.containsAll(list)) {
                    for (board: List<String> in boards) {
                        for (row: String in board) {
                            val line = row.replace("  ", " ").trim().split(" ").map { it.toInt() }
                            if  (line == list) {
                                winningBoard = board
                                for (it: String in winningBoard) {
                                    val winningLine = it.replace("  ", " ").trim().split(" ").map { it.toInt() }
                                    for (winningItem: Int in winningLine) {
                                        if (winningItem !in drawnNumbers) {
                                            sum+=winningItem
                                        }
                                    }
                                }
                                return sum*number
                            }
                        }
                    }
                }
            }
        }


        return allWinningRows.count()
    }

    fun part2(input: List<String>): Int {
        val toBeDrawnNumbers = input[0].split(",").map { it.toInt() }
        val drawnNumbers = mutableListOf<Int>()

        val boards = getBoards(input)
        val allWinningRows = mutableListOf<List<Int>>()
        for (board: List<String> in boards) {
            val winningRows = getWinningRows(board)
            allWinningRows.addAll(winningRows)
        }

        var winningBoard: List<String>
        var sum = 0
        var winningBoards = mutableListOf<List<String>>()
        for (number: Int in toBeDrawnNumbers) {
            drawnNumbers.add(number)
            for (list: List<Int> in allWinningRows) {
                if (drawnNumbers.containsAll(list)) {
                    for (board: List<String> in boards) {
                        for (row: String in board) {
                            val line = row.replace("  ", " ").trim().split(" ").map { it.toInt() }
                            if  (line == list) {
                                if (board !in winningBoards) {
                                    winningBoards.add(board.toList())
                                }
                            }
                        }
                    }
                }
            }
        }

        val lastWinningBoard = winningBoards.last()
        val lastWinningRows = getWinningRows(lastWinningBoard)
        drawnNumbers.clear()
        sum = 0
        for (number: Int in toBeDrawnNumbers) {
            drawnNumbers.add(number)
            for (list: List<Int> in lastWinningRows) {
                if (drawnNumbers.containsAll(list)) {
                        for (row: String in lastWinningBoard) {
                            val line = row.replace("  ", " ").trim().split(" ").map { it.toInt() }
                            for (item: Int in line) {
                                if (item !in drawnNumbers) {
                                    sum += item
                                }
                            }
                        }
                    return sum*number
                    }
                }
            }

        return winningBoards.count()
    }


    val inputTest = readInput("Day04_test")
    val input = readInput("Day04")
    println(part1(inputTest))
    println(part1(input))
    println(part2(inputTest))
    println(part2(input))

}
