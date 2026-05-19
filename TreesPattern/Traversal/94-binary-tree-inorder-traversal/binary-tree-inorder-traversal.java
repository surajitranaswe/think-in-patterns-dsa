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
     * Approach : Using DFS In-order Traversal (Left Node Right) Approach
     *
     * TC : O(n)
     * SC : O(h) (O(n) in worst case in case of skewed tree)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsTree(root, result);
        return result;
    }

    /**
     * Using DFS In-order Traversal (Left Node Right) Approach
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
        dfsTree(node.left, result);
        result.add(node.val);
        dfsTree(node.right, result);
    }
}
