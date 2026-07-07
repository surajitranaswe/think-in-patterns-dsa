class Solution {
    /**
     * Approach II : Using Optimized DP Approach
     *
     * TC : O(n)
     * SC : O(1)
     */
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int prev2 = 0;
        int prev1 = 1;
        int prev = 1;
        for (int i = 3; i <= n; i++) { // TC : O(n)
            int current = prev + prev1 + prev2;
            prev2 = prev1;
            prev1 = prev;
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
    public int tribonacciTabulation(int n) {
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
