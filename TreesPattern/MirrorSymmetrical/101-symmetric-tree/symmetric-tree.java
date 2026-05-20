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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfsTree(root.left, root.right);
    }

    /**
     * Using DFS Approach
     *
     * TC : O(n)
     * SC : O(h)
     */
    private boolean dfsTree(TreeNode p, TreeNode q) {
        // Base Case
        if (p == null && q == null) {
            // tree is symmetrical if both nodes are null
            return true;
        }
        if (p == null || q == null) {
            // if any node is null then tree is not symmetrical
            return false;
        }
        if (p.val != q.val) {
            // at a current node level the value of node should be same
            return false;
        }
        // Recursion Calls
        // here noth p and q TreeNodes have same values
        // compare left of TreeNode 'p' with right of TreeNode 'q'
        boolean isLeft = dfsTree(p.left, q.right);
        // compare right of TreeNode 'p' with left of TreeNode 'q'
        boolean isRight = dfsTree(p.right, q.left);
        return isLeft && isRight;
    }
}
