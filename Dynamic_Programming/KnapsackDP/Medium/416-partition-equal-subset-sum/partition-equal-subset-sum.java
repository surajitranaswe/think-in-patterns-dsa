class Solution {
    /**
     * Approach II : Using Optimized DP Approach
     *
     * TC : O(n) + O(n x k) ~ O(n x k)
     * SC : O(k)
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC : O(n)
            sum += nums[i];
        }
        if ((sum & 1) != 0) {
            /**
             * if sum is odd then we cannot partition
             * 'nums' into two subsets of equal sum
             */
            return false;
        }
        sum = sum / 2;
        /**
         * now the problem is converted to return if
         * array 'nums' can have a subset sum target = sum
         */
        boolean[] prev = new boolean[sum + 1]; // SC : O(k)
        prev[0] = true;
        for (int i = 1; i <= n; i++) {       // TC : O(n)
            boolean[] current = new boolean[sum + 1]; // SC : O(k)
            current[0] = true;
            for (int j = 1; j <= sum; j++) { // TC : O(k)
                // skip
                boolean skip = prev[j];
                boolean pick = false;
                if (nums[i - 1] <= j) {
                    pick = prev[j - nums[i - 1]];
                }
                current[j] = skip || pick;
            }
            prev = current;
        }
        return prev[sum];
    }

    /**
     * Approach I : Using Bottom-Up DP Approach
     *
     * TC : O(n) + O(n x k) ~ O(n x k)
     * SC : O(n x k)
     */
    public boolean canPartitionTabulation(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC : O(n)
            sum += nums[i];
        }
        if ((sum & 1) != 0) {
            /**
             * if sum is odd then we cannot partition
             * 'nums' into two subsets of equal sum
             */
            return false;
        }
        sum = sum / 2;
        /**
         * now the problem is converted to return if
         * array 'nums' can have a subset sum target = sum
         */
        boolean[][] dp = new boolean[n + 1][sum + 1]; // SC : O(n x k)
        /**
         * dp[i][j] denotes if it is possible to form a 
         * sum 'j' if we consider elements from [0 to (i - 1)]
         */
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {       // TC : O(n)
            for (int j = 1; j <= sum; j++) { // TC : O(k)
                // skip
                boolean skip = dp[i - 1][j];
                boolean pick = false;
                if (nums[i - 1] <= j) {
                    pick = dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] = skip || pick;
            }
        }
        return dp[n][sum];
    }
}
