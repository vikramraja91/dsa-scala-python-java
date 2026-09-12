"""
ARRAY / LIST BASICS CHEAT SHEET (Python)
------------------------------------------
Python has no separate fixed-size "Array" type in common use — `list` is
dynamic (grows/shrinks) and is what you'll use for almost everything here.
(There's also `array.array` for memory-efficient typed arrays, and numpy
arrays for numerical work, but plain `list` covers interview needs.)

Create:
    a = [1, 2, 3]              # from values
    a = []                     # empty list
    a = [0] * 5                # size 5, filled with 0
    a = list(range(1, 6))      # [1, 2, 3, 4, 5]

Read / write:
    a[0]                       # read index 0
    a[0] = 99                  # write index 0 (lists are mutable)
    len(a)                     # size

Add / remove (list is dynamic — these mutate IN PLACE, unlike Scala's Array):
    a.append(10)               # add to end, O(1) amortized
    a.insert(0, 10)             # insert at index, O(n)
    a.pop()                     # remove & return last element, O(1)
    a.pop(0)                    # remove & return element at index, O(n)
    a.remove(10)                 # remove first occurrence of value, O(n)

Common transforms (return NEW lists, don't mutate — unless noted):
    [x * 2 for x in a]          # map equivalent
    [x for x in a if x > 1]     # filter equivalent
    list(reversed(a))           # reverse (non-mutating)
    a.reverse()                 # reverse IN PLACE (mutates!)
    sorted(a)                    # sorted copy (non-mutating)
    a.sort()                     # sort IN PLACE (mutates!)
    sum(a) / max(a) / min(a)

Slicing / copying:
    a[1:3]                       # elements from index 1 to 2
    a[:2]                        # first 2 elements
    a[2:]                        # all but first 2
    a.copy()  or  a[:]           # shallow copy (new list, same elements)
"""

from typing import List, Optional, Tuple


def two_sum_sorted(arr: List[int], target: int) -> Optional[Tuple[int, int]]:
    """Two Sum (sorted input): finds indices of two numbers summing to target
    using two pointers from both ends.
    Pattern: Two Pointers. Time: O(n). Space: O(1).
    """
    lo, hi = 0, len(arr) - 1
    while lo < hi:
        total = arr[lo] + arr[hi]
        if total == target:
            return (lo, hi)
        elif total < target:
            lo += 1
        else:
            hi -= 1
    return None


def reverse_in_place(arr: List[int]) -> None:
    """Reverses a list in place by swapping from both ends inward.
    Pattern: Two Pointers. Time: O(n). Space: O(1).
    """
    lo, hi = 0, len(arr) - 1
    while lo < hi:
        arr[lo], arr[hi] = arr[hi], arr[lo]
        lo += 1
        hi -= 1


def remove_duplicates(arr: List[int]) -> int:
    """Removes duplicates from a sorted list in place, returning the count
    of unique elements. Elements beyond the returned count are leftover/undefined.
    Pattern: Two Pointers (slow/fast). Time: O(n). Space: O(1).
    """
    if not arr:
        return 0
    slow = 0
    for fast in range(1, len(arr)):
        if arr[fast] != arr[slow]:
            slow += 1
            arr[slow] = arr[fast]
    return slow + 1


def max_area(heights: List[int]) -> int:
    """Container With Most Water: finds max area between two vertical lines
    using inward-moving two pointers.
    Pattern: Two Pointers. Time: O(n). Space: O(1).
    """
    lo, hi = 0, len(heights) - 1
    best = 0
    while lo < hi:
        height = min(heights[lo], heights[hi])
        width = hi - lo
        best = max(best, height * width)
        if heights[lo] < heights[hi]:
            lo += 1
        else:
            hi -= 1
    return best


def max_sum_subarray_of_size_k(arr: List[int], k: int) -> int:
    """Maximum sum of any contiguous subarray of size k.
    Pattern: Sliding Window (fixed size). Time: O(n). Space: O(1).
    """
    if len(arr) < k:
        return 0
    window_sum = sum(arr[:k])
    best = window_sum
    for i in range(k, len(arr)):
        window_sum += arr[i] - arr[i - k]
        best = max(best, window_sum)
    return best


def min_sub_array_len(target: int, arr: List[int]) -> int:
    """Smallest length of a contiguous subarray whose sum is >= target.
    Returns 0 if none exists.
    Pattern: Sliding Window (variable size). Time: O(n). Space: O(1).
    """
    left = 0
    total = 0
    best = float("inf")
    for right in range(len(arr)):
        total += arr[right]
        while total >= target:
            best = min(best, right - left + 1)
            total -= arr[left]
            left += 1
    return 0 if best == float("inf") else best