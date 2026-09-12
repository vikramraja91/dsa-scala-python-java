package org.dsa.datastructures.linkedlists

/** A single node in a singly linked list. */
class Node[T](val value: T, var next: Node[T] = null)

/** A minimal singly linked list implementation, built from scratch (not using Scala's built-in List).
 * Demonstrates the underlying mechanics interviewers sometimes ask you to implement directly.
 */
class LinkedList[T] {
  var head: Node[T] = null

  /** Appends a value to the end. Time: O(n) (no tail pointer kept). */
  def append(value: T): Unit = {
    val node = new Node(value)
    if (head == null) head = node
    else {
      var cur = head
      while (cur.next != null) cur = cur.next
      cur.next = node
    }
  }

  /** Converts the list to a Scala List for easy testing/printing. Time: O(n). */
  def toScalaList: List[T] = {
    val buf = scala.collection.mutable.ListBuffer.empty[T]
    var cur = head
    while (cur != null) {
      buf += cur.value
      cur = cur.next
    }
    buf.toList
  }
}