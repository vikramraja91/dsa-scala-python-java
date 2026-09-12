package org.dsa.datastructures

/**
 * HASHMAP BASICS CHEAT SHEET (Scala)
 * ------------------------------------
 * Immutable: scala.collection.immutable.Map (default with `Map(...)`)
 * Mutable:   scala.collection.mutable.Map
 *
 * Create:
 *   val m = Map("a" -> 1, "b" -> 2)              // immutable
 *   val m = scala.collection.mutable.Map.empty[String, Int]
 *   val m = mutable.Map.empty[String, Int].withDefaultValue(0)  // avoids manual getOrElse
 *
 * Read:
 *   m("a")                       // throws if missing
 *   m.get("a")                   // Option[Int]
 *   m.getOrElse("a", 0)          // default if missing
 *   m.contains("a")
 *
 * Write (mutable only):
 *   m("a") = 5                   // insert/update
 *   m += ("a" -> 5)
 *   m -= "a"                     // remove
 *   m.getOrElseUpdate("a", 0)    // insert default if missing, return value
 *
 * Iterate:
 *   for ((k, v) <- m) ...
 *   m.keys / m.values
 *   m.foreach { case (k, v) => ... }
 *
 * Grouping (very common in DE — mirrors SQL/Spark groupBy):
 *   list.groupBy(_.someField)             // Map[K, List[V]]
 *   list.groupMapReduce(_.key)(_.value)(_ + _)  // group + aggregate in one step
 */

object HashMaps {

  /** Two Sum (unsorted): finds indices of two numbers summing to target using a hashmap of seen values.
   * Pattern: HashMap lookup. Time: O(n). Space: O(n).
   */
  def twoSum(arr: Array[Int], target: Int): Option[(Int, Int)] = {
    val seen = scala.collection.mutable.Map.empty[Int, Int] // value -> index
    for (i <- arr.indices) {
      val complement = target - arr(i)
      if (seen.contains(complement)) return Some((seen(complement), i))
      seen(arr(i)) = i
    }
    None
  }

  /** First non-repeating character in a string, or None if every character repeats.
   * Pattern: HashMap frequency counting. Time: O(n). Space: O(k).
   */
  def firstNonRepeatingChar(s: String): Option[Char] = {
    val counts = scala.collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    for (c <- s) counts(c) += 1
    s.find(c => counts(c) == 1)
  }

  /** Groups anagrams together from a list of strings.
   * Pattern: HashMap grouping by a derived key (sorted characters). Time: O(n * k log k). Space: O(n * k).
   */
  def groupAnagrams(words: List[String]): List[List[String]] =
    words.groupBy(_.sorted).values.toList

  /** Counts the frequency of each element in an array.
   * Pattern: HashMap counting. Time: O(n). Space: O(k).
   */
  def frequencyCount(arr: Array[Int]): Map[Int, Int] =
    arr.groupBy(identity).view.mapValues(_.length).toMap

  /** Finds the first duplicate value in an array, or None if all unique.
   * Pattern: HashSet membership check. Time: O(n). Space: O(n).
   */
  def firstDuplicate(arr: Array[Int]): Option[Int] = {
    val seen = scala.collection.mutable.Set.empty[Int]
    arr.find(x => !seen.add(x)) // add returns false if already present
  }
}