class Solution {
    /**
     * Approach : Using Top-Down DP Approach
     *
     * TC : O(n)
     * SC : O(n)
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1]; // SC : O(n)
        /**
         * dp[i] = total ways to reach ith step
         * by taking 1 or 2 steps
         * dp[0] = 1
         * dp[1] = 1
         * dp[2] = dp[1] + dp[0]
         * dp[3] = dp[2] + dp[1]
         */
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) { // TC : O(n)
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
