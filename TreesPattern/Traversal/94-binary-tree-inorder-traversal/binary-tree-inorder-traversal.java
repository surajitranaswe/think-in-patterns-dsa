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
        List<Integer> inorder = new ArrayList<>();
        dfsTree(root, inorder);
        return inorder;
    }

    /**
     * Using DFS In-order Traversal (Left Node Right) Approach
     *
     * TC : O(n)
     * SC : O(h)
     */
    private void dfsTree(TreeNode root, List<Integer> inorder) {
        // Base Case
        if (root == null) {
            return;
        }
        // Recursion Calls
        dfsTree(root.left, inorder);
        inorder.add(root.val);
        dfsTree(root.right, inorder);
    }
}
