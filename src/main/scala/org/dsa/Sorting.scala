package org.dsa

object Sorting {

  def bubbleSort(x: Array[Int]): Unit = {
    var i = 0
    var swapped = true
    while (swapped && i < x.length - 1) {
      swapped = false
      for (j <- 0 until x.length - 1 - i) {
        if (x(j) > x(j + 1)) {
          val y = x(j)
          x(j) = x(j + 1)
          x(j + 1) = y
          swapped = true
        }
      }
      i += 1
    }
  }


  def mergeSort(xs: List[Int]): List[Int] = {
    def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
      case (Nil, _) => right
      case (_, Nil) => left
      case (lh :: lt, rh :: rt) =>
        if (lh <= rh) lh :: merge(lt, right)
        else rh :: merge(left, rt)
    }

    val n = xs.length
    if (n <= 1) xs
    else {
      val (left, right) = xs.splitAt(n / 2)
      merge(mergeSort(left), mergeSort(right))
    }
  }
}