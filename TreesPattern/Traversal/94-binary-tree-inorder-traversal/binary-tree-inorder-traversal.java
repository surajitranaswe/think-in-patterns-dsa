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
     * Approach II : Using DFS In-order Traversal Iterative Approach
     *
     * TC : O(n)
     * SC : O(n)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        /**
         * we need to push all left children of Tree starting
         * from its root node into Stack
         */
        Stack<TreeNode> st = new Stack<>(); // SC : O(n)
        TreeNode current = root;
        while (current != null) {
            st.push(current);
            current = current.left;
        }
        while (!st.isEmpty()) { // TC : O(n)
            TreeNode node = st.pop();
            inorder.add(node.val);
            TreeNode rightNode = node.right;
            /**
             * if right node is not null push all 
             * its left node into the Stack
             */
            while (rightNode != null) {
                st.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return inorder;
    }

    /**
     * Approach I : Using DFS In-order Traversal Recursive Approach
     *
     * TC : O(n)
     * SC : O(h) (O(n) in worst case in case of skewed tree)
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
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
