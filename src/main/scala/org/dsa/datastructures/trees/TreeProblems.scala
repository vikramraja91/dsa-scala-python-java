package org.dsa.datastructures.trees

object TreeProblems {

  /** In-order traversal: left, node, right. Time: O(n). Space: O(h) recursion stack, h = height. */
  def inOrder(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else inOrder(root.left) ++ List(root.value) ++ inOrder(root.right)
  }

  /** Pre-order traversal: node, left, right. Time: O(n). Space: O(h). */
  def preOrder(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else List(root.value) ++ preOrder(root.left) ++ preOrder(root.right)
  }

  /** Post-order traversal: left, right, node. Time: O(n). Space: O(h). */
  def postOrder(root: TreeNode): List[Int] = {
    if (root == null) Nil
    else postOrder(root.left) ++ postOrder(root.right) ++ List(root.value)
  }

  /** Height of the tree (longest path from root to a leaf). Time: O(n). Space: O(h). */
  def height(root: TreeNode): Int = {
    if (root == null) 0
    else 1 + math.max(height(root.left), height(root.right))
  }

  /** Validates that a binary tree satisfies the BST property (left < node < right, recursively).
   * Pattern: Recursion with bounds. Time: O(n). Space: O(h).
   */
  def isValidBST(root: TreeNode, min: Option[Int] = None, max: Option[Int] = None): Boolean = {
    if (root == null) return true
    if (min.exists(root.value <= _) || max.exists(root.value >= _)) return false
    isValidBST(root.left, min, Some(root.value)) && isValidBST(root.right, Some(root.value), max)
  }
}