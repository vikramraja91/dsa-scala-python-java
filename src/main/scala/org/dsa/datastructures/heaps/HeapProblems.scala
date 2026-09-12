package org.dsa.datastructures.heaps

/**
 * HEAP / PRIORITY QUEUE CHEAT SHEET (Scala built-in)
 * -----------------------------------------------------
 *   import scala.collection.mutable.PriorityQueue
 *   val pq = PriorityQueue.empty[Int]                       // max-heap by default
 *   val pq = PriorityQueue.empty[Int](Ordering[Int].reverse) // min-heap
 *   pq.enqueue(5)
 *   pq.dequeue()      // removes & returns highest-priority element
 *   pq.head           // peek
 *
 * Scala's default PriorityQueue is a MAX-heap. Reverse the Ordering for a min-heap.
 */

object HeapProblems {

  /** Finds the k largest elements in an array using a min-heap of size k.
   * Pattern: Heap (top-K). Time: O(n log k). Space: O(k).
   */
  def kLargest(arr: Array[Int], k: Int): List[Int] = {
    val minHeap = scala.collection.mutable.PriorityQueue.empty[Int](Ordering[Int].reverse)
    for (n <- arr) {
      minHeap.enqueue(n)
      if (minHeap.size > k) minHeap.dequeue()
    }
    minHeap.toList.sorted(Ordering[Int].reverse)
  }

  /** Merges k sorted lists into one sorted list using a min-heap.
   * Pattern: Heap (k-way merge). Time: O(n log k) where n = total elements. Space: O(k).
   */
  def mergeKSorted(lists: List[List[Int]]): List[Int] = {
    // (value, listIndex, elementIndex) so we can find the next element after popping
    implicit val ord: Ordering[(Int, Int, Int)] = Ordering.by[(Int, Int, Int), Int](_._1).reverse
    val minHeap = scala.collection.mutable.PriorityQueue.empty[(Int, Int, Int)]

    for ((lst, i) <- lists.zipWithIndex if lst.nonEmpty) minHeap.enqueue((lst.head, i, 0))

    val result = scala.collection.mutable.ListBuffer.empty[Int]
    while (minHeap.nonEmpty) {
      val (value, listIdx, elemIdx) = minHeap.dequeue()
      result += value
      val nextIdx = elemIdx + 1
      if (nextIdx < lists(listIdx).length) {
        minHeap.enqueue((lists(listIdx)(nextIdx), listIdx, nextIdx))
      }
    }
    result.toList
  }
}