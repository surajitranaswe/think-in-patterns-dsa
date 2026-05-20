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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfsTree(root);
    }

    /**
     * Using DFS Approach
     *
     * TC : O(n)
     * SC : O(h)
     */
    private TreeNode dfsTree(TreeNode root) {
        // Base Case
        if (root == null) {
            return null;
        }
        // Recursion Calls
        // setting current node's value to new TreeNode 'invertedNode'
        TreeNode invertedNode = new TreeNode(root.val);
        // set current TreeNode's right to 'invertedNode' left
        invertedNode.left = dfsTree(root.right);
        // set current TreeNode's left to 'invertedNode' right
        invertedNode.right = dfsTree(root.left);
        return invertedNode;
    }
}
