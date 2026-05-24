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
     * TC : O(n) + O(n) ~ O(n)
     * SC : O(n) + O(n) ~ O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>(); // SC : O(n)
        for (int i = 0; i < n; i++) { // TC : O(n)
            inorderMap.put(inorder[i], i);
        }
        return solve(0, n - 1, new int[] { 0 },
            preorder, inorderMap); // TC : O(n), SC : O(n)
    }

    /**
     * Using DFS Approach
     *
     * TC : O(n)
     * SC : O(n)
     */
    private TreeNode solve(int low, int high, int[] idx, int[] preorder,
        Map<Integer, Integer> inorderMap) {
        // Base Case
        if (idx[0] >= preorder.length) {
            return null;
        }
        if (low > high) {
            return null;
        }
        // Recursion Calls
        int nodeVal = preorder[idx[0]];
        idx[0]++;
        TreeNode root = new TreeNode(nodeVal);
        int inorderIdx = inorderMap.get(nodeVal);
        root.left = solve(low, inorderIdx - 1, idx, preorder, inorderMap);
        root.right = solve(inorderIdx + 1, high, idx, preorder, inorderMap);
        return root;
    }
}
