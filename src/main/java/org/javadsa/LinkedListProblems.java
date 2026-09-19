package org.javadsa;

import java.util.ArrayList;
import java.util.List;

/** A single node in a singly linked list. */
class Node<T> {
    T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
        this.next = null;
    }
}

/**
 * A minimal singly linked list implementation, built from scratch (not using
 * java.util.LinkedList). Demonstrates the underlying mechanics interviewers
 * sometimes ask you to implement directly.
 */
class LinkedLists<T> {
    Node<T> head;

    /** Appends a value to the end. Time: O(n) (no tail pointer kept). */
    void append(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            Node<T> cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
    }

    /** Converts the list to a Java List for easy testing/printing. Time: O(n). */
    List<T> toList() {
        List<T> result = new ArrayList<>();
        Node<T> cur = head;
        while (cur != null) {
            result.add(cur.value);
            cur = cur.next;
        }
        return result;
    }
}

public class LinkedListProblems {

    /**
     * Reverses a singly linked list in place by rewiring `next` pointers.
     * Pattern: Iterative pointer reversal. Time: O(n). Space: O(1).
     */
    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> prev = null;
        Node<T> cur = head;
        while (cur != null) {
            Node<T> next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * Detects if a linked list has a cycle using Floyd's slow/fast pointer technique.
     * Pattern: Fast & Slow Pointers. Time: O(n). Space: O(1).
     */
    public static <T> boolean hasCycle(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * Merges two sorted linked lists into one sorted list.
     * Pattern: Two-pointer merge (like mergeSort's merge step). Time: O(n + m). Space: O(1) extra.
     */
    public static Node<Integer> mergeSorted(Node<Integer> a, Node<Integer> b) {
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> tail = dummy;
        Node<Integer> p1 = a, p2 = b;
        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        tail.next = (p1 != null) ? p1 : p2;
        return dummy.next;
    }

    /**
     * Finds the middle node using slow/fast pointers.
     * Pattern: Fast & Slow Pointers. Time: O(n). Space: O(1).
     */
    public static <T> Node<T> findMiddle(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}