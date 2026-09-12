package org.dsa.datastructures

/** A doubly linked list node for the LRU cache's ordering. */
private class DNode(var key: Int, var value: Int, var prev: DNode = null, var next: DNode = null)

/** Least Recently Used cache: O(1) get and put.
 * Pattern: HashMap (O(1) lookup) + Doubly Linked List (O(1) reorder/evict).
 * Classic "design"  — combines two structures deliberately.
 */
class LRUCache(capacity: Int) {
  private val map = scala.collection.mutable.Map.empty[Int, DNode]
  private val head = new DNode(-1, -1) // dummy head (most recently used side)
  private val tail = new DNode(-1, -1) // dummy tail (least recently used side)
  head.next = tail
  tail.prev = head

  private def remove(node: DNode): Unit = {
    node.prev.next = node.next
    node.next.prev = node.prev
  }

  private def insertAtFront(node: DNode): Unit = {
    node.next = head.next
    node.prev = head
    head.next.prev = node
    head.next = node
  }

  /** Returns the value for key, marking it as most recently used. Time: O(1). */
  def get(key: Int): Option[Int] = {
    map.get(key) match {
      case Some(node) =>
        remove(node)
        insertAtFront(node)
        Some(node.value)
      case None => None
    }
  }

  /** Inserts/updates a key, evicting the least recently used entry if over capacity. Time: O(1). */
  def put(key: Int, value: Int): Unit = {
    map.get(key).foreach(remove)
    val node = new DNode(key, value)
    insertAtFront(node)
    map(key) = node

    if (map.size > capacity) {
      val lru = tail.prev
      remove(lru)
      map.remove(lru.key)
    }
  }
}