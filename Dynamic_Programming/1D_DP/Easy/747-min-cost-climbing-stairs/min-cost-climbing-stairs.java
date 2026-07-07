class Solution {
    /**
     * Approach : Using Top-Down DP Approach
     *
     * TC : O(n)
     * SC : O(n)
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1]; // SC : O(n)
        /**
         * dp[i] = minimum cost to reach ith step
         * by taking 1 or 2 steps
         * dp[0] = 0
         * dp[1] = Min(cost[0] + dp[0], 0) = 0
         * dp[2] = Min(cost[1] + dp[1], cost[0] + dp[0])
         */
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) { // TC : O(n)
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[n];
    }
}
