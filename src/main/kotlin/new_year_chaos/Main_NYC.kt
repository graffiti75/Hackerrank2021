package new_year_chaos

var mPermutations = 0

/*
 * Complete the 'minimumBribes' function below.
 * The function accepts INTEGER_ARRAY q as parameter.
 */
fun minimumBribes(q: Array<Int>): Unit {
    // Write your code here
    var inArray = Array(q.size) { 0 }
    var permArray = Array(q.size) { 0 }

    // Step 0: Created the inArray.
    for (i in q.indices) inArray[i] = i + 1

    // Cycle of 4 Steps.
    var same = false
    var ind = 0
    while (mPermutations <= q.size && !same) {
        // ------------------------->>>>>

        println("--- ind = $ind")
        permArray = Array(q.size) { 0 }
        println("--- minimumBribes() -> permArray = ${permArray.printArray()}, --- ind = $ind")

        // Step 1: Calculate number of bribes necessary for each item, between arrayIn and arrayOut (q).
        for (i in q.indices) {
            val inElem = inArray[i]
            val inIndex = inArray.toList().indexOf(inElem)
            val qIndex = q.toList().indexOf(inElem)
            val permutationsNumber = inIndex - qIndex
            permArray[i] = kotlin.math.abs(permutationsNumber)
        }

        // Step 2: Find the biggest bribery value (let's call it "big") .
        val aux = permArray.toList().max()
        val inIndex = permArray.toList().indexOf(aux)
//        val bigBriberyIndex = inArray[inIndex]

        // Step 3: Perform "big" briberies, and update arrayIn.
//        inArray = performPermutations(inArray, q, bigBriberyIndex)
        inArray = performPermutations(inArray, q, inIndex)

        // Step 4: Check if arrayIn == arrayOut (q).
        same = checkArrays(inArray, q)

        println("--- minimumBribes() -> same = $same")
        ind++

        // <<<<<-------------------------
    }

    println("--- minimumBribes() -> mPermutations = $mPermutations, --- ind = $ind, same = $same")

    if (same)
        println(mPermutations)
    else
        println("Too chaotic")
}

private fun performPermutations(inArray: Array<Int>, q: Array<Int>, inArrayIndex: Int): Array<Int> {
    var newArray = inArray
    val outIndex = q.indexOf(newArray[inArrayIndex]) // 2
    if (inArrayIndex > outIndex) {
        for (i in inArrayIndex downTo (outIndex + 1))
            newArray = swapArray(newArray, i, i - 1)
    } else {
        for (i in inArrayIndex until outIndex)
            newArray = swapArray(newArray, i, i + 1)
    }
    println("\t--- performPermutations() -> mPermutations = $mPermutations, --- newArray = ${newArray.printArray()}")
    return newArray
}

private fun swapArray(inArray: Array<Int>, currentIndex: Int, indexToSwap: Int): Array<Int> {
    val aux = inArray[currentIndex]                 // 5
    inArray[currentIndex] = inArray[indexToSwap]    // arr[4] = arr[3] -> arr[4] = 4
    inArray[indexToSwap] = aux                      // arr[3] = 5
    mPermutations ++
    return inArray
}

private fun checkArrays(inArray: Array<Int>, q: Array<Int>): Boolean {
    var cont = 0
    if (inArray.size == q.size) {
        for (i in inArray.indices)
            if (inArray[i] == q[i]) cont++
        if (cont == inArray.size) return true
    }
    return false
}

fun <T : Comparable<T>> Iterable<T>.max(): T {
    val iterator = iterator()
    var max = iterator.next()
    while (iterator.hasNext()) {
        val e = iterator.next()
        if (max < e) max = e
    }
    return max
}

fun Array<Int>.printArray(): String {
    var out = ""
    this.forEach { out += "$it " }
    return out
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()
    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()
        val q = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        minimumBribes(q)
    }
}