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
     * Approach : Using DFS Pre-order Traversal (Node Left Right) Approach
     *
     * TC : O(n)
     * SC : O(h) (O(n) in worst case in case of skewed tree)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsTree(root, result);
        return result;
    }

    /**
     * Using DFS Pre-order Traversal (Node Left Right) Approach
     *
     * TC : O(n)
     * SC : O(h)
     */
    private void dfsTree(TreeNode node, List<Integer> result) {
        // Base Case
        if (node == null) {
            return;
        }
        // Recursion Calls
        result.add(node.val);
        dfsTree(node.left, result);
        dfsTree(node.right, result);
    }
}
