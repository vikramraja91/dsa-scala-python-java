"""
LINKED LIST BASICS (Python)
------------------------------
Python has no built-in singly linked list type — you build it yourself,
same as in Scala/Java. This is exactly the kind of "implement from scratch"
"""

from typing import Optional, TypeVar, Generic, List

T = TypeVar("T")


class Node(Generic[T]):
    """A single node in a singly linked list."""

    def __init__(self, value: T, next: "Optional[Node[T]]" = None):
        self.value = value
        self.next = next


class LinkedList(Generic[T]):
    """A minimal singly linked list implementation, built from scratch."""

    def __init__(self):
        self.head: Optional[Node[T]] = None

    def append(self, value: T) -> None:
        """Appends a value to the end. Time: O(n) (no tail pointer kept)."""
        node = Node(value)
        if self.head is None:
            self.head = node
        else:
            cur = self.head
            while cur.next is not None:
                cur = cur.next
            cur.next = node

    def to_list(self) -> List[T]:
        """Converts the linked list to a Python list for easy testing/printing. Time: O(n)."""
        result = []
        cur = self.head
        while cur is not None:
            result.append(cur.value)
            cur = cur.next
        return result


def reverse(head: Optional[Node[T]]) -> Optional[Node[T]]:
    """Reverses a singly linked list in place by rewiring `next` pointers.
    Pattern: Iterative pointer reversal. Time: O(n). Space: O(1).
    """
    prev = None
    cur = head
    while cur is not None:
        nxt = cur.next
        cur.next = prev
        prev = cur
        cur = nxt
    return prev


def has_cycle(head: Optional[Node[T]]) -> bool:
    """Detects if a linked list has a cycle using Floyd's slow/fast pointer technique.
    Pattern: Fast & Slow Pointers. Time: O(n). Space: O(1).
    """
    slow = head
    fast = head
    while fast is not None and fast.next is not None:
        slow = slow.next
        fast = fast.next.next
        if slow is fast:
            return True
    return False


def merge_sorted(a: Optional[Node[int]], b: Optional[Node[int]]) -> Optional[Node[int]]:
    """Merges two sorted linked lists into one sorted list.
    Pattern: Two-pointer merge (like mergeSort's merge step). Time: O(n + m). Space: O(1) extra.
    """
    dummy = Node(0)
    tail = dummy
    p1, p2 = a, b
    while p1 is not None and p2 is not None:
        if p1.value <= p2.value:
            tail.next = p1
            p1 = p1.next
        else:
            tail.next = p2
            p2 = p2.next
        tail = tail.next
    tail.next = p1 if p1 is not None else p2
    return dummy.next


def find_middle(head: Optional[Node[T]]) -> Optional[Node[T]]:
    """Finds the middle node using slow/fast pointers.
    Pattern: Fast & Slow Pointers. Time: O(n). Space: O(1).
    """
    slow = head
    fast = head
    while fast is not None and fast.next is not None:
        slow = slow.next
        fast = fast.next.next
    return slow