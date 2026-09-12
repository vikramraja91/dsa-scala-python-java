package org.dsa.datastructures.graphs

/**
 * GRAPH CHEAT SHEET
 * -------------------
 * No built-in Graph type in Scala — represent as an adjacency list:
 *   val graph: Map[Int, List[Int]] = Map(1 -> List(2, 3), 2 -> List(4), ...)
 *
 * DE relevance: DAGs model job/task dependencies (Airflow, Spark stages) —
 * topological sort answers "what order can these run in?"
 */

object GraphProblems {

  /** Breadth-first traversal from a starting node.
   * Pattern: Queue-based BFS. Time: O(V + E). Space: O(V).
   */
  def bfs(graph: Map[Int, List[Int]], start: Int): List[Int] = {
    val visited = scala.collection.mutable.Set(start)
    val queue = scala.collection.mutable.Queue(start)
    val order = scala.collection.mutable.ListBuffer.empty[Int]

    while (queue.nonEmpty) {
      val node = queue.dequeue()
      order += node
      for (neighbor <- graph.getOrElse(node, Nil) if !visited.contains(neighbor)) {
        visited.add(neighbor)
        queue.enqueue(neighbor)
      }
    }
    order.toList
  }

  /** Depth-first traversal from a starting node.
   * Pattern: Stack/recursion-based DFS. Time: O(V + E). Space: O(V).
   */
  def dfs(graph: Map[Int, List[Int]], start: Int): List[Int] = {
    val visited = scala.collection.mutable.Set.empty[Int]
    val order = scala.collection.mutable.ListBuffer.empty[Int]

    def visit(node: Int): Unit = {
      if (!visited.contains(node)) {
        visited.add(node)
        order += node
        graph.getOrElse(node, Nil).foreach(visit)
      }
    }
    visit(start)
    order.toList
  }

  /** Detects a cycle in a directed graph using DFS with a "currently in recursion stack" set.
   * Pattern: DFS with recursion-stack tracking. Time: O(V + E). Space: O(V).
   */
  def hasCycle(graph: Map[Int, List[Int]]): Boolean = {
    val visited = scala.collection.mutable.Set.empty[Int]
    val inStack = scala.collection.mutable.Set.empty[Int]

    def visit(node: Int): Boolean = {
      if (inStack.contains(node)) return true
      if (visited.contains(node)) return false
      visited.add(node)
      inStack.add(node)
      val cyclic = graph.getOrElse(node, Nil).exists(visit)
      inStack.remove(node)
      cyclic
    }
    graph.keys.exists(visit)
  }

  /** Topological sort of a DAG (valid execution order respecting dependencies).
   * Pattern: DFS post-order, reversed. Time: O(V + E). Space: O(V).
   * Directly relevant to DE: this is how job schedulers order dependent tasks.
   */
  def topologicalSort(graph: Map[Int, List[Int]]): List[Int] = {
    val visited = scala.collection.mutable.Set.empty[Int]
    val result = scala.collection.mutable.ListBuffer.empty[Int]

    def visit(node: Int): Unit = {
      if (!visited.contains(node)) {
        visited.add(node)
        graph.getOrElse(node, Nil).foreach(visit)
        result.prepend(node) // node goes before its dependents once all its deps are processed
      }
    }
    graph.keys.foreach(visit)
    result.toList
  }
}