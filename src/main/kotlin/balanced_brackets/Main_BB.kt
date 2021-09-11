package balanced_brackets

import java.util.*

/**
 * Source:
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 */

var TOKENS : Array<Array<Char>> = arrayOf(arrayOf('{', '}'), arrayOf('[', ']'), arrayOf('(', ')'))

fun isOpenTerm(c: Char): Boolean {
    for (array in TOKENS) {
        if (array[0] == c) {
            return true
        }
    }
    return false
}

fun matches(openTerm: Char, closeTerm: Char): Boolean {
    for (array in TOKENS) {
        if (array[0] == openTerm) {
            return array[1] == closeTerm
        }
    }
    return false
}

fun isBalanced(expression: String): Boolean {
    val stack : Stack<Char> = Stack<Char>()
    for (c in expression.toCharArray()) {
        if (isOpenTerm(c)) {
            stack.push(c)
        } else {
            if (stack.isEmpty() || !matches(stack.pop(), c)) {
                return false
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isBalanced("{()[{({})[]()}]}([])"))
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
}