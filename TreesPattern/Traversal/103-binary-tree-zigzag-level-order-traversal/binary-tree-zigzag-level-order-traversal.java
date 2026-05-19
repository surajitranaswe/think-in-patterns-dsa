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
     * SC : O(n) - all nodes will be stored in Queue
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>(); // SC : O(n)
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) { // TC : O(n)
            int size = queue.size();
            Integer[] levelNodes = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if ((level & 1) == 0) {
                    // even level - add level nodes from left to right
                    levelNodes[i] = node.val;
                } else {
                    // odd level - add level nodes from right to left
                    levelNodes[size - i - 1] = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(Arrays.asList(levelNodes));
            level++;
        }
        return result;
    }
}
