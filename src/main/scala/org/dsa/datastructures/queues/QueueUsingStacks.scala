package org.dsa.datastructures.queues

/**
 * QUEUE CHEAT SHEET (Scala built-in)
 * -------------------------------------
 *   val q = scala.collection.mutable.Queue.empty[Int]
 *   q.enqueue(1)
 *   q.dequeue()      // removes & returns front
 *   q.front          // peek without removing
 *
 * FIFO — First In, First Out.
 */

/** Implements a queue using two stacks — a classic "build X using Y" interview question. */
class QueueUsingStacks[T] {
  private val inStack = scala.collection.mutable.Stack.empty[T]
  private val outStack = scala.collection.mutable.Stack.empty[T]

  /** Amortized O(1): pushes always go to inStack. */
  def enqueue(value: T): Unit = inStack.push(value)

  /** Amortized O(1): only re-shuffles inStack -> outStack when outStack is empty. */
  def dequeue(): T = {
    if (outStack.isEmpty) {
      while (inStack.nonEmpty) outStack.push(inStack.pop())
    }
    outStack.pop()
  }

  def isEmpty: Boolean = inStack.isEmpty && outStack.isEmpty
}