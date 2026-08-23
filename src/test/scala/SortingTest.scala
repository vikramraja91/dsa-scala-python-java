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

  test("mergeSort handles negative numbers") {
    Sorting.mergeSort(List(-3, 5, -1, 0, 2)) shouldBe List(-3, -1, 0, 2, 5)
  }

  // ---------- quickSort -------

  test("quickSort sorts unsorted array") {
    val arr = Array(5, 2, 7, 3, 8, 2, 6)
    Sorting.quickSort(arr)
    arr shouldBe Array(2, 2, 3, 5, 6, 7, 8)
  }
}