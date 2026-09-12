"""
DICT (HASHMAP) BASICS CHEAT SHEET (Python)
---------------------------------------------
Python's dict is a hashmap by default — no separate mutable/immutable
distinction like Scala. Dicts are always mutable. For an immutable/read-only
view, use types.MappingProxyType(d)

Create:
    m = {"a": 1, "b": 2}              # literal
    m = {}                             # empty dict
    m = dict()                         # same as above
    from collections import defaultdict
    m = defaultdict(int)               # avoids manual .get(key, 0)

Read:
    m["a"]                             # KeyError if missing
    m.get("a")                         # None if missing
    m.get("a", 0)                      # default if missing
    "a" in m                           # membership check (like .contains)

Write:
    m["a"] = 5                         # insert/update
    del m["a"]                         # remove
    m.setdefault("a", 0)               # insert default if missing, return value
    m.pop("a", None)                   # remove and return, with default if missing

Iterate:
    for k, v in m.items(): ...
    m.keys() / m.values()
    for k in m: ...                    # iterates keys by default

Grouping (very common in DE — mirrors SQL/Spark groupBy):
    from collections import defaultdict
    groups = defaultdict(list)
    for item in items:
        groups[item.key].append(item)

    from collections import Counter
    Counter(items)                      # frequency count in one line
"""

from typing import List, Optional, Tuple, Dict
from collections import defaultdict, Counter


def two_sum(arr: List[int], target: int) -> Optional[Tuple[int, int]]:
    """Two Sum (unsorted): finds indices of two numbers summing to target
    using a hashmap of seen values.
    Pattern: HashMap lookup. Time: O(n). Space: O(n).
    """
    seen: Dict[int, int] = {}  # value -> index
    for i, num in enumerate(arr):
        complement = target - num
        if complement in seen:
            return seen[complement], i
        seen[num] = i
    return None


def first_non_repeating_char(s: str) -> Optional[str]:
    """First non-repeating character in a string, or None if every character repeats.
    Pattern: HashMap frequency counting. Time: O(n). Space: O(k).
    """
    counts = Counter(s)
    for c in s:
        if counts[c] == 1:
            return c
    return None


def group_anagrams(words: List[str]) -> List[List[str]]:
    """Groups anagrams together from a list of strings.
    Pattern: HashMap grouping by a derived key (sorted characters).
    Time: O(n * k log k). Space: O(n * k).
    """
    groups: Dict[str, List[str]] = defaultdict(list)
    for word in words:
        key = "".join(sorted(word))
        groups[key].append(word)
    return list(groups.values())


def frequency_count(arr: List[int]) -> Dict[int, int]:
    """Counts the frequency of each element in a list.
    Pattern: HashMap counting. Time: O(n). Space: O(k).
    """
    return dict(Counter(arr))


def first_duplicate(arr: List[int]) -> Optional[int]:
    """Finds the first duplicate value in a list, or None if all unique.
    Pattern: HashSet membership check. Time: O(n). Space: O(n).
    """
    seen = set()
    for x in arr:
        if x in seen:
            return x
        seen.add(x)
    return None