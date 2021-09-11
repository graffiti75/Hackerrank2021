package arrays_left_rotation

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    // Write your code here
    val shiftedArray = Array(a.size) { 0 }
    var index = 0
    for (i in d until a.size)
        shiftedArray[index++] = a[i]
    for (i in 0 until d)
        shiftedArray[index++] = a[i]
    return shiftedArray
}

fun main(args: Array<String>) {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")
    val n = firstMultipleInput[0].toInt()
    val d = firstMultipleInput[1].toInt()
    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    val result = rotLeft(a, d)
    println(result.joinToString(" "))
}
