class Solution {
    /**
     * Approach II : Using Optimized DP Approach
     *
     * TC : O(n)
     * SC : O(1)
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n < 2) {
            return 0;
        }
        int prev2 = 0;
        int prev = 0;
        for (int i = 2; i <= n; i++) { // TC : O(n)
            int current = Math.min(cost[i - 1] + prev, cost[i - 2] + prev2);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    /**
     * Approach I : Using Top-Down DP Approach
     *
     * TC : O(n)
     * SC : O(n)
     */
    public int minCostClimbingStairsTabulation(int[] cost) {
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
