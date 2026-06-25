/**
 * Approach II : Using Segment Tree Approach
 *
 * TC : O(n) + O(q x log(n))
 * - O(n) for prefixSum formation
 * - O(q x log(n)) for all queries execution
 * SC : O(n) + O(q x log(n))
 */
class NumArray {
    private int n;
    private int[] nums;
    private int[] segTree;

    /**
     * Using Segment Trees Approach
     *
     * TC : O(n)
     * SC : O(n) + O(log(n)) ~ O(n)
     */
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.segTree = new int[4 * n]; // SC : O(4 x n)
        buildSegmentTree(0, n - 1, 0); // TC : O(n), SC : O(log(n))
    }
    
    /**
     * Using Segment Trees Approach
     *
     * TC : O(log(n))
     * SC : O(log(n))
     */
    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }

    /**
     * Using Segment Trees Approach
     *
     * TC : O(n)
     * SC : O(log(n))
     */
    private void buildSegmentTree(int l, int r, int idx) {
        // Base Case
        if (l == r) {
            segTree[idx] = nums[l];
            return;
        }
        // Recursion Calls
        int mid = l + (r - l) / 2;
        buildSegmentTree(l, mid, 2 * idx + 1);
        buildSegmentTree(mid + 1, r, 2 * idx + 2);
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }

    /**
     * Using Segment Trees Approach
     *
     * TC : O(log(n))
     * SC : O(log(n))
     */
    private int querySegmentTree(int start, int end, int idx, int l, int r) {
        // Base Case
        // Case 1 : Out of Bound range
        if (start > r || end < l) {
            return 0;
        }
        // Case 2 : Full-overlap
        if (l >= start && r <= end) {
            return segTree[idx];
        }
        // Recursion Calls
        int mid = l + (r - l) / 2;
        int leftSum = querySegmentTree(start, end, 2 * idx + 1, l, mid);
        int rightSum = querySegmentTree(start, end, 2 * idx + 2, mid + 1, r);
        return leftSum + rightSum;
    }
}

/**
 * Approach I : Using Prefix-Sum Approach
 *
 * TC : O(n) + O(q)
 * - O(n) for prefixSum formation
 * - O(q) for all queries execution
 * SC : O(n)
 */
class NumArrayPrefixSum {
    private int n;
    private int[] prefixSum;

    /**
     * Using Prefix-Sum Approach
     *
     * TC : O(n)
     * SC : O(n)
     */
    public NumArrayPrefixSum(int[] nums) {
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