class Solution {
    /**
     * Approach I : Using Top-Down DP Approach
     *
     * TC : O(n)
     * SC : O(n)
     */
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1]; // SC : O(n)
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) { // TC : O(n)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
