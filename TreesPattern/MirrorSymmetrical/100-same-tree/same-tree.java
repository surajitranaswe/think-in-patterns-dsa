/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * Approach : Using DFS Approach
     *
     * TC : O(n)
     * SC : O(h) ~ O(n) in worst case if tree is a skewed tree
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case
        if (p == null && q == null) {
            // null nodes are same
            return true;
        }
        if (p == null || q == null) {
            // if one of the node becomes null then p and q nodes are not same
            return false;
        }
        if (p.val != q.val) {
            // not same trees
            return false;
        }
        // Recursion Calls
        // here p and q node values are same
        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);
        return isLeftSame && isRightSame;
    }
}
