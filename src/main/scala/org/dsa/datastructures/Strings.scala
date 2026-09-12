package org.dsa.datastructures

/**
 * STRING BASICS CHEAT SHEET (Scala)
 * ----------------------------------
 * String in Scala is IMMUTABLE (like Java). Every "modification" returns a new String.
 *
 * Create:
 *   val s = "hello"
 *   val s = "a" * 3                  // "aaa"
 *   val s = new String(Array('a','b'))
 *
 * Access:
 *   s(0)                             // 'h' — char at index
 *   s.charAt(0)                      // same, Java-style
 *   s.length
 *
 * Common ops (all return NEW strings, never mutate):
 *   s.toUpperCase / s.toLowerCase
 *   s.reverse
 *   s.substring(1, 3)
 *   s.split(" ")                     // Array[String]
 *   s.trim
 *   s.replace("a", "b")
 *   s.contains("ell")
 *   s.indexOf("l")
 *
 * Convert:
 *   s.toArray                        // Array[Char]
 *   s.toList                         // List[Char]
 *   s.toCharArray                    // Array[Char] (Java-style)
 *   chars.mkString                   // Array[Char]/List[Char] -> String
 *
 * Building strings efficiently (avoid += in a loop, it's O(n) each time):
 *   val sb = new StringBuilder
 *   sb.append("a")
 *   sb.toString
 */

object Strings {

  /** Checks if a string is a palindrome using two pointers from both ends.
   * Pattern: Two Pointers. Time: O(n). Space: O(1).
   */
  def isPalindrome(s: String): Boolean = {
    var lo = 0
    var hi = s.length - 1
    while (lo < hi) {
      if (s(lo) != s(hi)) return false
      lo += 1
      hi -= 1
    }
    true
  }

  /** Checks if two strings are anagrams of each other via character frequency counting.
   * Pattern: HashMap counting. Time: O(n). Space: O(k) where k = distinct chars.
   */
  def isAnagram(a: String, b: String): Boolean = {
    if (a.length != b.length) return false
    val counts = scala.collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    for (c <- a) counts(c) += 1
    for (c <- b) counts(c) -= 1
    counts.values.forall(_ == 0)
  }

  /** Length of the longest substring without repeating characters.
   * Pattern: Sliding Window (variable) + Set. Time: O(n). Space: O(min(n, charset)).
   */
  def longestUniqueSubstring(s: String): Int = {
    val seen = scala.collection.mutable.Set.empty[Char]
    var left = 0
    var best = 0
    for (right <- s.indices) {
      while (seen.contains(s(right))) {
        seen.remove(s(left))
        left += 1
      }
      seen.add(s(right))
      best = math.max(best, right - left + 1)
    }
    best
  }

  /** Longest substring containing at most k distinct characters.
   * Pattern: Sliding Window (variable) + HashMap. Time: O(n). Space: O(k).
   */
  def longestSubstringKDistinct(s: String, k: Int): Int = {
    if (k == 0) return 0
    val counts = scala.collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    var left = 0
    var best = 0
    for (right <- s.indices) {
      counts(s(right)) += 1
      while (counts.size > k) {
        counts(s(left)) -= 1
        if (counts(s(left)) == 0) counts.remove(s(left))
        left += 1
      }
      best = math.max(best, right - left + 1)
    }
    best
  }

  /** Reverses the order of words in a string (words separated by whitespace).
   * Pattern: Split + Reverse. Time: O(n). Space: O(n).
   */
  def reverseWords(s: String): String =
    s.trim.split("\\s+").reverse.mkString(" ")
}