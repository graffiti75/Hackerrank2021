package queue_with_two_stacks

import java.util.*

/**
 * Source:
 * https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 */

class MyQueue<T> {
    private val stackNewestOnTop = Stack<T>()
    private val stackOldestOnTop = Stack<T>()

    fun enqueue(value: T) { // Add item
        stackNewestOnTop.push(value)
    }

    fun peek(): T { // Get "oldest" item
        // Move elements from stackNewest to stackOldest
        shiftStacks()
        return stackOldestOnTop.peek()
    }

    private fun shiftStacks() {
        if (stackOldestOnTop.isEmpty()) {
            while (!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop())
            }
        }
    }

    fun dequeue(): T { // Get "oldest" item and remove it
        // Move elements from stackNewest to stackOldest
        shiftStacks()
        return stackOldestOnTop.pop()
    }

    fun print() {
        stackOldestOnTop.forEach {
            print("$it ")
        }
        println()
    }
}

fun main() {
    val queue = MyQueue<Int>()

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    println(queue.peek())
    queue.print()
    println(queue.dequeue())
    queue.print()

    /*
    println(isBalanced("{}"))
    println(isBalanced("{(]"))

    val stack : Stack<Char> = Stack<Char>()
    stack.push('c')
    stack.push('a')
    stack.push('b')
    stack.push('e')
    stack.push('c')
    stack.push('a')
    stack.pop()
    println(stack)
    stack.peek()
    println(stack)
     */
}