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
     * Approach : Using DFS (Post Order Traversal) Approach
     *
     * TC : O(n)
     * SC : O(h) ~ O(n) in worst case if tree is a skewed tree
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfsLCATree(root).node;
    }

    /**
     * Using DFS (Post Order Traversal) Approach
     *
     * TC : O(n)
     * SC : O(h)
     */
    private Pair dfsLCATree(TreeNode root) {
        // Base Case
        if (root == null) {
            return new Pair(0, null);
        }
        // Recursion Calls
        Pair left = dfsLCATree(root.left);
        Pair right = dfsLCATree(root.right);
        if (left.depth > right.depth) {
            // return LCA of deepest leaves in left sub-tree
            return new Pair(left.depth + 1, left.node);
        } else if (left.depth < right.depth) {
            // return LCA of deepest leaves in right sub-tree
            return new Pair(right.depth + 1, right.node);
        } else {
            /**
             * as root node has both depths same from its
             * left and right sub-tree so it is the LCA
             */
            return new Pair(left.depth + 1, root);
        }
    }
}

class Pair {
    int depth;
    TreeNode node;

    public Pair(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}
