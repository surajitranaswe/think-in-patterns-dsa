class Solution {
    /**
     * Approach II : Using Space Optimization (Optimized DP) Approach
	 *
	 * TC : O(n)
	 * SC : O(1) 
	 */
    public int rob(int[] nums) {
        int n = nums.length;
		int prev2 = 0;
		int prev = nums[0];
		for (int i = 1; i < n; i++) { // TC : O(n)
			int current = Math.max(
				nums[i] + (i > 1 ? prev2 : 0),
				prev
			);
			prev2 = prev;
			prev = current;
		}
		return prev;
    }

    /**
     * Approach I : Using Tabulation (Bottom-Up) Approach
	 *
	 * TC : O(n)
	 * SC : O(n) 
	 */
    public int robTabulation(int[] nums) {
        int n = nums.length;
		int[] dp = new int[n]; // SC : O(n)
		/**
		 * here dp[i] denotes the maximum money
		 * that can be looted till index 'i'
		 *
		 * dp[0] = nums[0];
		 * dp[1] = Max(dp[0], nums[1]);
		 * as we cannot pick two consecutive indices
		 * dp[2] = Math.max(nums[2] + dp[0], dp[1])
		 */
		dp[0] = nums[0];
		for (int i = 1; i < n; i++) { // TC : O(n)
			dp[i] = Math.max(
				nums[i] + (i > 1 ? dp[i - 2] : 0),
				dp[i - 1]
			);
		}
		return dp[n - 1];
    }
}
