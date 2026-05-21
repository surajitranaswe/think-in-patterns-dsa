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
     * Approach : Using Property of Binary Search Tree Approach
     *
     * TC : O(log(n))
     * SC : O(log(n))
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // Base Case
        if (root == null) {
            return null;
        }
        // Recursion Calls
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            // node with value 'val' can be found in the left-subtree
            return searchBST(root.left, val);
        } else {
            // node with value 'val' can be found in the right-subtree
            return searchBST(root.right, val);
        }
    }
}
