package org.dsa.datastructures

/**
 * ARRAY BASICS CHEAT SHEET (Scala)
 * ---------------------------------
 * Array[Int] is FIXED SIZE and MUTABLE — you can change elements, but not grow/shrink it.
 * For a growable/shrinkable array, use scala.collection.mutable.ArrayBuffer instead.
 *
 * Create:
 *   val a  = Array(1, 2, 3)          // from values
 *   val a  = Array.empty[Int]        // empty array
 *   val a  = new Array[Int](5)       // size 5, all zeros
 *   val a  = Array.fill(5)(0)        // size 5, filled with 0
 *   val a  = Array.range(1, 6)       // Array(1,2,3,4,5)
 *   val a  = (1 to 5).toArray        // Array(1,2,3,4,5)
 *
 * Read / write:
 *   a(0)                             // read index 0
 *   a(0) = 99                        // write index 0 (allowed — Array is mutable)
 *   a.length                         // size
 *
 * "Add" an element (Array can't grow, so this creates a NEW array):
 *   val b = a :+ 10                  // append -> new array
 *   val b = 10 +: a                  // prepend -> new array
 *   val b = a ++ Array(4, 5)         // concatenate -> new array
 *
 * If you actually need to grow/shrink repeatedly, use ArrayBuffer instead:
 *   import scala.collection.mutable.ArrayBuffer
 *   val buf = ArrayBuffer.empty[Int]
 *   buf += 1                          // append in place
 *   buf += 2
 *   buf -= 1                          // remove in place
 *   val arr = buf.toArray             // convert back to Array when needed
 *
 * Common transforms (return NEW arrays/collections, don't mutate):
 *   a.map(_ * 2)
 *   a.filter(_ > 1)
 *   a.reverse
 *   a.sorted
 *   a.sum / a.max / a.min
 *   a.toList / a.toVector
 *
 * Slicing / copying:
 *   a.slice(1, 3)                    // elements from index 1 to 2
 *   a.take(2)                        // first 2 elements
 *   a.drop(2)                        // all but first 2
 *   a.clone()                        // shallow copy (new array, same elements)
 */

object Arrays {

  /** Two Sum (sorted input): finds indices of two numbers summing to target using two pointers from both ends.
   * Pattern: Two Pointers. Time: O(n). Space: O(1).
   */
  def twoSumSorted(arr: Array[Int], target: Int): Option[(Int, Int)] = {
    var lo = 0
    var hi = arr.length - 1
    while (lo < hi) {
      val sum = arr(lo) + arr(hi)
      if (sum == target) return Some((lo, hi))
      else if (sum < target) lo += 1
      else hi -= 1
    }
    None
  }

  /** Reverses an array in place by swapping from both ends inward.
   * Pattern: Two Pointers. Time: O(n). Space: O(1).
   */
  def reverseInPlace(arr: Array[Int]): Unit = {
    var lo = 0
    var hi = arr.length - 1
    while (lo < hi) {
      val tmp = arr(lo)
      arr(lo) = arr(hi)
      arr(hi) = tmp
      lo += 1
      hi -= 1
    }
  }

  /** Removes duplicates from a sorted array in place, returning the count of unique elements.
   * Elements beyond the returned count are undefined/leftover.
   * Pattern: Two Pointers (slow/fast). Time: O(n). Space: O(1).
   */
  def removeDuplicates(arr: Array[Int]): Int = {
    if (arr.isEmpty) return 0
    var slow = 0
    for (fast <- 1 until arr.length) {
      if (arr(fast) != arr(slow)) {
        slow += 1
        arr(slow) = arr(fast)
      }
    }
    slow + 1
  }

  /** Container With Most Water: finds max area between two vertical lines using inward-moving two pointers.
   * Pattern: Two Pointers. Time: O(n). Space: O(1).
   */
  def maxArea(heights: Array[Int]): Int = {
    var lo = 0
    var hi = heights.length - 1
    var best = 0
    while (lo < hi) {
      val height = math.min(heights(lo), heights(hi))
      val width = hi - lo
      best = math.max(best, height * width)
      if (heights(lo) < heights(hi)) lo += 1 else hi -= 1
    }
    best
  }

  /** Maximum sum of any contiguous subarray of size k.
   * Pattern: Sliding Window (fixed size). Time: O(n). Space: O(1).
   */
  def maxSumSubarrayOfSizeK(arr: Array[Int], k: Int): Int = {
    if (arr.length < k) return 0
    var windowSum = arr.take(k).sum
    var best = windowSum
    for (i <- k until arr.length) {
      windowSum += arr(i) - arr(i - k)
      best = math.max(best, windowSum)
    }
    best
  }

  /** Smallest length of a contiguous subarray whose sum is >= target. Returns 0 if none exists.
   * Pattern: Sliding Window (variable size). Time: O(n). Space: O(1).
   */
  def minSubArrayLen(target: Int, arr: Array[Int]): Int = {
    var left = 0
    var sum = 0
    var best = Int.MaxValue
    for (right <- arr.indices) {
      sum += arr(right)
      while (sum >= target) {
        best = math.min(best, right - left + 1)
        sum -= arr(left)
        left += 1
      }
    }
    if (best == Int.MaxValue) 0 else best
  }
}