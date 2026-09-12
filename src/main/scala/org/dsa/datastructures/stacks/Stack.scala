package org.dsa.datastructures.stacks

/**
 * STACK CHEAT SHEET (Scala built-in)
 * -------------------------------------
 *   val s = scala.collection.mutable.Stack.empty[Int]
 *   s.push(1)
 *   s.pop()          // removes & returns top
 *   s.top            // peek without removing
 *   s.isEmpty
 *
 * LIFO — Last In, First Out.
 */

/** A minimal stack implementation from scratch, backed by an ArrayBuffer. */
class Stack[T] {
  private val elements = scala.collection.mutable.ArrayBuffer.empty[T]

  def push(value: T): Unit = elements.append(value)

  def pop(): T = {
    if (elements.isEmpty) throw new NoSuchElementException("pop on empty stack")
    val v = elements.last
    elements.remove(elements.length - 1)
    v
  }

  def peek: T = elements.last
  def isEmpty: Boolean = elements.isEmpty
  def size: Int = elements.length
}