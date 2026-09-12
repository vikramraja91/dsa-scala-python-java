package org.dsa.datastructures.linkedlists

object LinkedListProblems {

  /** Reverses a singly linked list in place by rewiring `next` pointers.
   * Pattern: Iterative pointer reversal. Time: O(n). Space: O(1).
   */
  def reverse[T](head: Node[T]): Node[T] = {
    var prev: Node[T] = null
    var cur = head
    while (cur != null) {
      val next = cur.next
      cur.next = prev
      prev = cur
      cur = next
    }
    prev
  }

  /** Detects if a linked list has a cycle using Floyd's slow/fast pointer technique.
   * Pattern: Fast & Slow Pointers. Time: O(n). Space: O(1).
   */
  def hasCycle[T](head: Node[T]): Boolean = {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (slow == fast) return true
    }
    false
  }

  /** Merges two sorted linked lists into one sorted list.
   * Pattern: Two-pointer merge (like mergeSort's merge step). Time: O(n + m). Space: O(1) extra (rewires nodes).
   */
  def mergeSorted(a: Node[Int], b: Node[Int]): Node[Int] = {
    val dummy = new Node[Int](0)
    var tail = dummy
    var p1 = a
    var p2 = b
    while (p1 != null && p2 != null) {
      if (p1.value <= p2.value) { tail.next = p1; p1 = p1.next }
      else { tail.next = p2; p2 = p2.next }
      tail = tail.next
    }
    tail.next = if (p1 != null) p1 else p2
    dummy.next
  }

  /** Finds the middle node using slow/fast pointers (slow ends at middle when fast reaches the end).
   * Pattern: Fast & Slow Pointers. Time: O(n). Space: O(1).
   */
  def findMiddle[T](head: Node[T]): Node[T] = {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    slow
  }
}