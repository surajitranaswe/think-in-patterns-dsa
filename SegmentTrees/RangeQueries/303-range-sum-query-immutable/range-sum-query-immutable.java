/**
 * Approach I : Using Prefix-Sum Approach
 *
 * TC : O(n) + O(q)
 * - O(n) for prefixSum formation
 * - O(q) for all queries execution
 * SC : O(n)
 */
class NumArray {
    private int n;
    private int[] prefixSum;

    /**
     * Using Prefix-Sum Approach
     *
     * TC : O(n)
     * SC : O(n)
     */
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.prefixSum = new int[n];  // SC : O(n)
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) { // TC : O(n)
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }
    
    /**
     * Using Prefix-Sum Approach
     *
     * TC : O(1)
     * SC : O(1)
     */
    public int sumRange(int left, int right) {
        if (left < 0 || left >= n || right < 0 || right >= n) {
            return -1;
        }
        if (left > 0) {
            return prefixSum[right] - prefixSum[left - 1];
        }
        return prefixSum[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
