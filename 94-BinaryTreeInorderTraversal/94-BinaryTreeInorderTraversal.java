// Last updated: 19/05/2026, 23:28:26
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    /**
18     * Approach : Using DFS Inorder Traversal (Left Node Right) Approach
19     *
20     * TC : O(n)
21     * SC : O(h) (O(n) in worst case in case of skewed tree)
22     */
23    public List<Integer> inorderTraversal(TreeNode root) {
24        List<Integer> result = new ArrayList<>();
25        dfsTree(root, result);
26        return result;
27    }
28
29    /**
30     * Using DFS Inorder Traversal (Left Node Right) Approach
31     *
32     * TC : O(n)
33     * SC : O(h)
34     */
35    private void dfsTree(TreeNode node, List<Integer> result) {
36        // Base Case
37        if (node == null) {
38            return;
39        }
40        // Recursion Calls
41        dfsTree(node.left, result);
42        result.add(node.val);
43        dfsTree(node.right, result);
44    }
45}
46