package hourglass

/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {
    // Write your code here
    val sums = mutableListOf<Int>()
    for (i in 1 until 5)
    for (j in 1 until 5) {
        val firstLine = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]
        val secondLine = arr[i][j]
        val thirdLine = arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1]
        val sum = firstLine + secondLine + thirdLine
//        println("[$i][$j]  $firstLine, $secondLine, $thirdLine")
        sums.add(sum)
//        println("---")
    }

//    sums.map {
//        println(it)
//    }
//    print("---+---")

//    return sums.maxOrNull() ?: 0
    return max(sums)
}

private fun max(list: List<Int>): Int {
    var max = list[0]
    for (i in 1 until list.size) if (max < list[i] ) max = list[i]
    return max
}

/*
 * https://www.hackerrank.com/challenges/2d-array/problem
 * ?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
fun main(args: Array<String>) {
    val arr = Array(6) { Array(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }
    val result = hourglassSum(arr)
    println(result)
}