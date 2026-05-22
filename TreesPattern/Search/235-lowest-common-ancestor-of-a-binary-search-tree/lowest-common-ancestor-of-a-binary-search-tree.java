/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /**
     * Approach : Using DFS + BST Property Approach
     *
     * TC : O(log(n))
     * SC : O(log(n)) 
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfsBST(root, p, q);
    }

    /**
     * Using DFS + BST Property Approach
     *
     * TC : O(log(n))
     * SC : O(log(n)) 
     */
    private TreeNode dfsBST(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            // node is an ancestor of itself, so root is the LCS
            return root;
        }
        if (p.val < root.val && q.val > root.val) {
            // split node found at root, so root is the LCA
            return root;
        }
        // Recursion Calls
        if (p.val < root.val && q.val < root.val) {
            // TreeNodes 'p' and 'q' cannot be under right sub-tree
            return dfsBST(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            // TreeNodes 'p' and 'q' cannot be under left sub-tree
            return dfsBST(root.right, p, q);
        }
        return root; // default return
    }
}
