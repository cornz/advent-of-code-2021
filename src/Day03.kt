fun main() {

    fun getMostUsedCharOfIndexOfLine(input: List<String>, index: Int, mostOrLeast: Boolean): String {
        val arrayList = arrayListOf<Char>()
        for (row: String in input) {
            arrayList.add(row[index])
        }
        val countOfZeros = arrayList.count { it.equals("0".get(0)) }
        val countOfOnes = arrayList.count { it.equals("1".get(0)) }
        if (mostOrLeast) {
            if (countOfZeros > countOfOnes) {
                return "0"
            } else if (countOfZeros < countOfOnes) {
                return "1"
            } else {
                return "1"
            }
        } else {
            if (countOfZeros > countOfOnes) {
                return "1"
            } else if (countOfZeros < countOfOnes) {
                return "0"
            } else {
                return "0"
            }
        }
    }

    fun filterList(list: List<String>, index: Int, mostOrLeast: Boolean): List<String> {
        val bit = getMostUsedCharOfIndexOfLine(list, index, mostOrLeast)
        return list.filter { it[index].toString() == bit }
    }

    fun part1(input: List<String>): Int {
        var bitSequence = ""
        var gamma = 0
        var epsilon = 0
        for (i in 0 until input[0].length) {
            bitSequence += getMostUsedCharOfIndexOfLine(input, i, true)
        }
        val bitSequenceInversed = bitSequence.replace("0", "#").replace("1", "0").replace("#", "1")

        gamma = Integer.parseInt(bitSequence,2)
        epsilon = Integer.parseInt(bitSequenceInversed, 2)

        return  gamma*epsilon

    }

    fun part2(input: List<String>): Int {
        var oxygenList = input
        var co2List = input
        var oxygen = 0
        var co2 = 0
        for (i in 0 until input[0].length) {
            oxygenList = filterList(oxygenList, i, true)
            if (oxygenList.size == 1) {
                break
            }
        }
        for (i in 0 until input[0].length) {
            co2List = filterList(co2List, i, false)
            if (co2List.size == 1) {
                break
            }
        }
        oxygen = Integer.parseInt(oxygenList[0], 2)
        co2 = Integer.parseInt(co2List[0], 2)
        return oxygen*co2
    }


    val inputTest = readInput("Day03_test")
    val input = readInput("Day03")
    //println(part1(inputTest))
    //println(part1(input))
    println(part2(inputTest))
    println(part2(input))

}
