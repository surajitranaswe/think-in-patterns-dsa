class Solution {
    /**
     * Approach I : Using Tabulation (Bottom-Up) Approach
     *
     * TC : O(m x n)
     * SC : O(m x n)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];   // SC : O(m x n)
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int j = 1; j < n; j++) { // TC : O(n)
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) { // TC : O(m)
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {     // TC : O(m)
            for (int j = 1; j < n; j++) { // TC : O(n)
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
