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
     * Approach : Using DFS + Property of BST Approach
     *
     * TC : O(n)
     * SC : O(log(n))
     */
    public boolean isValidBST(TreeNode root) {
        return dfsTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Using DFS + Property of BST Approach
     *
     * TC : O(n)
     * SC : O(log(n))
     */
    private boolean dfsTree(TreeNode root, long min, long max) {
        // Base Case
        if (root == null) {
            return true;
        }
        // Recursion Calls
        if (root.val <= min || root.val >= max) {
            return false;
        }
        boolean isLeftBST = dfsTree(root.left, min, root.val);
        boolean isRightBST = dfsTree(root.right, root.val, max);
        return isLeftBST && isRightBST;
    }
}
