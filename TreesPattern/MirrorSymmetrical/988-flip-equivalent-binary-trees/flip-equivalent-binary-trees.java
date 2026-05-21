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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base Case
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            // non-equivalent node found
            return false;
        }
        /**
         * Recursion Calls
         * we can choose to flip or not flip at this node 'root1'
         */
        boolean noFlip = flipEquiv(root1.left, root2.left) &&
            flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) &&
            flipEquiv(root1.right, root2.left);
        return noFlip || flip;
    }
}
