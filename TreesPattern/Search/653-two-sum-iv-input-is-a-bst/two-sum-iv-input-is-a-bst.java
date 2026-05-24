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
     * Approach II : Using Better (Hashing + Recursion) Approach
     *
     * TC : O(n)
     * SC : O(h) + O(n) ~ O(n)
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>(); // SC : O(n)
        return solve(root, k, set); // TC : O(n), SC : O(h)
    }

    /**
     * Using Recursion Approach
     *
     * TC : O(n)
     * SC : O(h)
     */
    private boolean solve(TreeNode root, int k, Set<Integer> set) {
        // Base Case
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        // Recursion Calls
        set.add(root.val);
        boolean left = solve(root.left, k, set);
        boolean right = solve(root.right, k, set);
        return left || right;
    }

    /**
     * Approach I : Using Brute-Force (Two Pointers + DFS Inorder Traversal) Approach
     *
     * TC : O(n)
     * SC : O(h)
     */
    public boolean findTargetBruteForce(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        // inorder traversal of BST gives us nodes in sorted order of values
        dfsTree(root, inorder);
        int p = 0;
        int q = inorder.size() - 1;
        while (p < q) {
            int sum = inorder.get(p) + inorder.get(q);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                p++;
            } else {
                q--;
            }
        }
        return false;
    }

    /**
     * Using DFS Inorder Traversal Approach
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
