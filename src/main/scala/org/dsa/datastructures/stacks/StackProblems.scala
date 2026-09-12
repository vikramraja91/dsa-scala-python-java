package org.dsa.datastructures.stacks

object StackProblems {

  /** Checks if brackets/parentheses in a string are validly matched and nested.
   * Pattern: Stack matching. Time: O(n). Space: O(n).
   */
  def isValidParentheses(s: String): Boolean = {
    val stack = scala.collection.mutable.Stack.empty[Char]
    val pairs = Map(')' -> '(', ']' -> '[', '}' -> '{')
    for (c <- s) {
      if (c == '(' || c == '[' || c == '{') stack.push(c)
      else if (pairs.contains(c)) {
        if (stack.isEmpty || stack.pop() != pairs(c)) return false
      }
    }
    stack.isEmpty
  }

  /** Evaluates a postfix (Reverse Polish Notation) expression, e.g. Array("2","1","+","3","*") -> 9.
   * Pattern: Stack-based evaluation. Time: O(n). Space: O(n).
   */
  def evalRPN(tokens: Array[String]): Int = {
    val stack = scala.collection.mutable.Stack.empty[Int]
    val ops = Set("+", "-", "*", "/")
    for (t <- tokens) {
      if (ops.contains(t)) {
        val b = stack.pop()
        val a = stack.pop()
        val res = t match {
          case "+" => a + b
          case "-" => a - b
          case "*" => a * b
          case "/" => a / b
        }
        stack.push(res)
      } else stack.push(t.toInt)
    }
    stack.pop()
  }
}