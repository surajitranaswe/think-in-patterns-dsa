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
     * Approach : Using DFS (Inorder Traversal) Approach
     *
     * TC : O(n)
     * SC : O(log(n)) + O(n) ~ O(n)
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>(); // SC : O(n)
        dfsInorder(root, inorder); // TC : O(n), SC : O(log(n))
        return inorder.get(k - 1);
    }

    /**
     * Using DFS (Inorder Traversal) Approach
     *
     * TC : O(n)
     * SC : O(log(n))
     */
    private void dfsInorder(TreeNode root, List<Integer> inorder) {
        // Base Case
        if (root == null) {
            return;
        }
        // Recursion Calls
        dfsInorder(root.left, inorder);
        inorder.add(root.val);
        dfsInorder(root.right, inorder);
    }
}
