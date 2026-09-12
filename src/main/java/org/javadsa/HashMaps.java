package org.javadsa;


/**
 * MAP (HASHMAP) BASICS CHEAT SHEET (Java)
 * -------------------------------------------
 * HashMap<K, V> — the standard mutable hashmap. Unordered.
 * LinkedHashMap<K, V> — preserves insertion order.
 * TreeMap<K, V> — sorted by key.
 *
 * Create:
 *   Map<String, Integer> m = new HashMap<>();
 *   Map<String, Integer> m = Map.of("a", 1, "b", 2);   // immutable, fixed at creation
 *
 * Read:
 *   m.get("a")                         // null if missing (NOT an exception, unlike Scala's m("a"))
 *   m.getOrDefault("a", 0)              // default if missing
 *   m.containsKey("a")
 *
 * Write:
 *   m.put("a", 5);                      // insert/update
 *   m.remove("a");                      // remove
 *   m.putIfAbsent("a", 0);               // insert only if missing
 *   m.merge("a", 1, Integer::sum);       // insert-or-accumulate in one call — useful for counting
 *   m.computeIfAbsent("a", k -> new ArrayList<>()).add(value); // classic groupBy pattern
 *
 * Iterate:
 *   for (Map.Entry<String, Integer> e : m.entrySet()) { e.getKey(); e.getValue(); }
 *   for (String k : m.keySet()) { ... }
 *   m.forEach((k, v) -> ...);
 *
 * Grouping (very common in DE — mirrors SQL/Spark groupBy):
 *   Map<K, List<V>> groups = new HashMap<>();
 *   for (T item : items) {
 *       groups.computeIfAbsent(item.getKey(), k -> new ArrayList<>()).add(item);
 *   }
 *
 *   // or with Streams:
 *   Map<K, List<T>> groups = items.stream().collect(Collectors.groupingBy(T::getKey));
 */

import java.util.*;
import java.util.stream.Collectors;

public class HashMaps {

    /**
     * Two Sum (unsorted): finds indices of two numbers summing to target
     * using a hashmap of seen values.
     * Pattern: HashMap lookup. Time: O(n). Space: O(n).
     */
    public static Optional<int[]> twoSum(int[] arr, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (seen.containsKey(complement)) {
                return Optional.of(new int[]{seen.get(complement), i});
            }
            seen.put(arr[i], i);
        }
        return Optional.empty();
    }

    /**
     * First non-repeating character in a string, or empty if every character repeats.
     * Pattern: HashMap frequency counting. Time: O(n). Space: O(k).
     */
    public static Optional<Character> firstNonRepeatingChar(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.merge(c, 1, Integer::sum);
        }
        for (char c : s.toCharArray()) {
            if (counts.get(c) == 1) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    /**
     * Groups anagrams together from a list of strings.
     * Pattern: HashMap grouping by a derived key (sorted characters).
     * Time: O(n * k log k). Space: O(n * k).
     */
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            java.util.Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }

    /**
     * Counts the frequency of each element in an array.
     * Pattern: HashMap counting. Time: O(n). Space: O(k).
     */
    public static Map<Integer, Integer> frequencyCount(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : arr) {
            counts.merge(x, 1, Integer::sum);
        }
        return counts;
    }

    /**
     * Finds the first duplicate value in an array, or empty if all unique.
     * Pattern: HashSet membership check. Time: O(n). Space: O(n).
     */
    public static Optional<Integer> firstDuplicate(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int x : arr) {
            if (!seen.add(x)) { // add returns false if already present
                return Optional.of(x);
            }
        }
        return Optional.empty();
    }
}