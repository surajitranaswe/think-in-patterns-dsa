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
     * Approach : Using BFS Traversal Approach
     *
     * TC : O(n) - all nodes will be visited once
     * SC : O(n) + O(n) ~ O(n)
     *    - O(n) all nodes will be stored in Queue
     *    - O(n) - size of Stack (k levels x (n / k))
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>(); // SC : O(n)
        queue.offer(root);
        int levels = 0;
        /**
         * We need a stack here to reverse the levels
         * after the node values are set for all levels
         */
        Stack<List<Integer>> st = new Stack<>();    // SC : O(n)
        while (!queue.isEmpty()) { // TC : O(n)
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            st.push(levelNodes);
            levels++;
        }
        while (!st.isEmpty()) {
            result.add(st.pop());
        }
        return result;
    }
}
