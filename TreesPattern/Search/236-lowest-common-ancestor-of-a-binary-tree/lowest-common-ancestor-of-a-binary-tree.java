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
    private TreeNode lcaNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfsTree(root, p, q);
        return lcaNode;
    }

    private int dfsTree(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null) {
            // we cannot search 'p' and 'q' underneath
            return 0;
        }
        // Recursion Calls
        /**
         * we need to count if p or q is found
         * under left or right sub-tree
         */
        int leftCount = dfsTree(root.left, p, q);
        int rightCount = dfsTree(root.right, p, q);
        int selfCount = 0;
        if (root.val == p.val || root.val == q.val) {
            /**
             * one of the node 'p' or 'q' is found
             * underneath TreeNode 'root' so that
             * node will return 1
             */
            selfCount = 1;
        }
        int totalCount = selfCount + leftCount + rightCount;
        if (totalCount == 2 && lcaNode == null) {
            lcaNode = root;
        }
        return totalCount;
    }
}
