package org.dsa

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SortingTest extends AnyFunSuite with Matchers {

  // ---------- bubbleSort ----------
  test("bubbleSort sorts an unsorted array") {
    val arr = Array(5, 3, 8, 1, 9, 2)
    Sorting.bubbleSort(arr)
    arr shouldBe Array(1, 2, 3, 5, 8, 9)
  }

  test("bubbleSort handles an empty array") {
    val arr = Array.empty[Int]
    Sorting.bubbleSort(arr)
    arr shouldBe Array.empty[Int]
  }

  test("bubbleSort handles a single-element array") {
    val arr = Array(42)
    Sorting.bubbleSort(arr)
    arr shouldBe Array(42)
  }

  test("bubbleSort handles an already-sorted array") {
    val arr = Array(1, 2, 3, 4, 5)
    Sorting.bubbleSort(arr)
    arr shouldBe Array(1, 2, 3, 4, 5)
  }

  test("bubbleSort handles a reverse-sorted array") {
    val arr = Array(5, 4, 3, 2, 1)
    Sorting.bubbleSort(arr)
    arr shouldBe Array(1, 2, 3, 4, 5)
  }

  test("bubbleSort handles duplicate elements") {
    val arr = Array(3, 1, 3, 2, 1)
    Sorting.bubbleSort(arr)
    arr shouldBe Array(1, 1, 2, 3, 3)
  }

  test("bubbleSort handles negative numbers") {
    val arr = Array(-3, 5, -1, 0, 2)
    Sorting.bubbleSort(arr)
    arr shouldBe Array(-3, -1, 0, 2, 5)
  }

  // ---------- mergeSort ----------
  test("mergeSort sorts an unsorted list") {
    Sorting.mergeSort(List(5, 3, 8, 1, 9, 2)) shouldBe List(1, 2, 3, 5, 8, 9)
  }

  test("mergeSort handles an empty list") {
    Sorting.mergeSort(Nil) shouldBe Nil
  }

  test("mergeSort handles a single-element list") {
    Sorting.mergeSort(List(42)) shouldBe List(42)
  }

  test("mergeSort handles an already-sorted list") {
    Sorting.mergeSort(List(1, 2, 3, 4, 5)) shouldBe List(1, 2, 3, 4, 5)
  }

  test("mergeSort handles a reverse-sorted list") {
    Sorting.mergeSort(List(5, 4, 3, 2, 1)) shouldBe List(1, 2, 3, 4, 5)
  }

  test("mergeSort handles duplicate elements") {
    Sorting.mergeSort(List(3, 1, 3, 2, 1)) shouldBe List(1, 1, 2, 3, 3)
  }

  test("mergeSort handles negative numbers") {
    Sorting.mergeSort(List(-3, 5, -1, 0, 2)) shouldBe List(-3, -1, 0, 2, 5)
  }

  test("mergeSort does not mutate the original list") {
    val original = List(3, 1, 2)
    Sorting.mergeSort(original)
    original shouldBe List(3, 1, 2) // Lists are immutable, so this should always hold
  }

  // ---------- property-based style check ----------

  test("bubbleSort result matches Scala's built-in sort") {
    val arr = Array(9, -2, 5, 0, 3, -7, 1)
    val expected = arr.sorted
    Sorting.bubbleSort(arr)
    arr shouldBe expected
  }

  test("mergeSort result matches Scala's built-in sort") {
    val xs = List(9, -2, 5, 0, 3, -7, 1)
    Sorting.mergeSort(xs) shouldBe xs.sorted
  }
}