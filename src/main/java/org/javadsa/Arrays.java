package org.javadsa;

/**
 * ARRAY BASICS CHEAT SHEET (Java)
 * ---------------------------------
 * int[] is FIXED SIZE (like Scala's Array). For dynamic resizing, use
 * ArrayList<Integer> instead — but note it boxes primitives (Integer, not int),
 * which has a performance cost.
 *
 * Create:
 *   int[] a = {1, 2, 3};             // from values
 *   int[] a = new int[5];            // size 5, all zeros
 *   int[] a = new int[0];            // empty array
 *   Arrays.fill(a, 0);                // fill an existing array with a value
 *
 * Read / write:
 *   a[0]                              // read index 0
 *   a[0] = 99;                        // write index 0
 *   a.length                          // size (NOT a method — no parentheses)
 *
 * "Add" an element (array can't grow, so this means creating a NEW array):
 *   int[] b = Arrays.copyOf(a, a.length + 1);
 *   b[b.length - 1] = 10;
 *
 * If you need to grow/shrink repeatedly, use ArrayList instead:
 *   List<Integer> list = new ArrayList<>();
 *   list.add(1);                      // append
 *   list.remove(Integer.valueOf(1));  // remove by value (careful: remove(int) removes by INDEX)
 *   int[] arr = list.stream().mapToInt(Integer::intValue).toArray(); // convert back
 *
 * Common transforms (java.util.Arrays utility methods):
 *   Arrays.sort(a);                   // sorts IN PLACE (mutates!)
 *   int[] copy = Arrays.copyOf(a, a.length);  // copy
 *   Arrays.toString(a);               // "[1, 2, 3]" for printing
 *   int[] slice = Arrays.copyOfRange(a, 1, 3); // elements from index 1 to 2
 *
 * Streams (functional-style transforms, return new arrays/values):
 *   Arrays.stream(a).map(x -> x * 2).toArray();
 *   Arrays.stream(a).filter(x -> x > 1).toArray();
 *   Arrays.stream(a).sum();
 *   Arrays.stream(a).max().getAsInt();
 */

import java.util.Optional;

public class Arrays {

    /**
     * Two Sum (sorted input): finds indices of two numbers summing to target
     * using two pointers from both ends.
     * Pattern: Two Pointers. Time: O(n). Space: O(1).
     */
    public static Optional<int[]> twoSumSorted(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum == target) {
                return Optional.of(new int[]{lo, hi});
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return Optional.empty();
    }

    /**
     * Reverses an array in place by swapping from both ends inward.
     * Pattern: Two Pointers. Time: O(n). Space: O(1).
     */
    public static void reverseInPlace(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            lo++;
            hi--;
        }
    }

    /**
     * Removes duplicates from a sorted array in place, returning the count
     * of unique elements. Elements beyond the returned count are leftover/undefined.
     * Pattern: Two Pointers (slow/fast). Time: O(n). Space: O(1).
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int slow = 0;
        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return slow + 1;
    }

    /**
     * Container With Most Water: finds max area between two vertical lines
     * using inward-moving two pointers.
     * Pattern: Two Pointers. Time: O(n). Space: O(1).
     */
    public static int maxArea(int[] heights) {
        int lo = 0, hi = heights.length - 1;
        int best = 0;
        while (lo < hi) {
            int height = Math.min(heights[lo], heights[hi]);
            int width = hi - lo;
            best = Math.max(best, height * width);
            if (heights[lo] < heights[hi]) lo++;
            else hi--;
        }
        return best;
    }

    /**
     * Maximum sum of any contiguous subarray of size k.
     * Pattern: Sliding Window (fixed size). Time: O(n). Space: O(1).
     */
    public static int maxSumSubarrayOfSizeK(int[] arr, int k) {
        if (arr.length < k) return 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) windowSum += arr[i];
        int best = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            best = Math.max(best, windowSum);
        }
        return best;
    }

    /**
     * Smallest length of a contiguous subarray whose sum is >= target.
     * Returns 0 if none exists.
     * Pattern: Sliding Window (variable size). Time: O(n). Space: O(1).
     */
    public static int minSubArrayLen(int target, int[] arr) {
        int left = 0, sum = 0;
        int best = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum >= target) {
                best = Math.min(best, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }
}