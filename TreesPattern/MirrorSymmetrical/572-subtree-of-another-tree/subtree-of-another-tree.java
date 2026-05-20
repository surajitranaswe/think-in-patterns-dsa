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
     * TC : O(n²)
     * SC : O(h)
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfsTree(root, subRoot);
    }

    /**
     * Using DFS Approach
     *
     * TC : O(n²)
     * SC : O(h)
     */
    private boolean dfsTree(TreeNode root, TreeNode subRoot) {
        // Base Case
        if (root == null && subRoot == null) {
            // if both TreeNodes are null then subRoot is the sub-tree of root
            return true;
        }
        if (root == null || subRoot == null) {
            // if any of TreeNodes is null then subRoot cannot be sub-tree of root
            return false;
        }
        boolean isCurrentNodeSame = root.val == subRoot.val &&
            isSameTree(root, subRoot); // TC : O(n), SC : O(n)
        /**
         * we need to perform DFS from both child nodes
         */
        boolean isLeftSubTree = dfsTree(root.left, subRoot);
        boolean isRightSubTree = dfsTree(root.right, subRoot);
        return isCurrentNodeSame || isLeftSubTree || isRightSubTree;
    }

    /**
     * Using DFS Approach
     *
     * TC : O(n)
     * SC : O(h)
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case
        if (p == null && q == null) {
            // if both TreeNodes are null then they are same trees
            return true;
        }
        if (p == null || q == null) {
            // if any of TreeNodes is null then both TreeNodes cannot be same trees
            return false;
        }
        if (p.val != q.val) {
            // same-tree not possible
            return false;
        }
        // Recursion Calls
        // here TreeNodes p and q have same values
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
