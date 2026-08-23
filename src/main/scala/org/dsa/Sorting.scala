package org.dsa

object Sorting {

  /** Bubble sort: repeatedly swaps adjacent out-of-order elements.
   * Time: O(n) best, O(n^2) avg/worst. Space: O(1). Stable. Mutates in place.
   */
  def bubbleSort(x: Array[Int]): Unit = {
    var i = 0
    var swapped = true
    while (swapped && i < x.length - 1) {
      swapped = false
      for (j <- 0 until x.length - 1 - i) {
        if (x(j) > x(j + 1)) {
          val y = x(j)
          x(j) = x(j + 1)
          x(j + 1) = y
          swapped = true
        }
      }
      i += 1
    }
  }

  /** Merge sort: recursively splits and merges sorted halves.
   * Time: O(n log n) all cases. Space: O(n). Stable. Returns new list, does not mutate.
   */
  def mergeSort(xs: List[Int]): List[Int] = {
    def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
      case (Nil, _) => right
      case (_, Nil) => left
      case (lh :: lt, rh :: rt) =>
        if (lh <= rh) lh :: merge(lt, right)
        else rh :: merge(left, rt)
    }

    val n = xs.length
    if (n <= 1) xs
    else {
      val (left, right) = xs.splitAt(n / 2)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  /** Quick sort: partitions around a pivot (last element, Lomuto scheme), recurses on both sides.
   * Time: O(n log n) avg, O(n^2) worst (sorted/reverse-sorted input). Space: O(log n) avg. Not stable. Mutates in place.
   */

  def quickSort(x: Array[Int]): Unit = {
    def swap(i: Int, j: Int): Unit = {
      val tmp = x(i)
      x(i) = x(j)
      x(j) = tmp
    }

    def partition(lo: Int, hi: Int) = {
      val pivot = x(hi)
      var i = lo

      for (j <- lo until hi) {
        if (x(j) <= pivot) {
          swap(i, j)
          i += 1
        }
      }
      swap(i, hi)
      i
    }

    def sort(lo: Int, hi: Int): Unit = {
      if (lo < hi) {
        val p = partition(lo, hi)
        sort(lo, p - 1)
        sort(p + 1, hi)
      }
    }

    sort(0, x.length - 1)
  }
}