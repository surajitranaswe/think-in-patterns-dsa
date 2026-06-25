/**
 * Approach : Using Segment Tree Approach
 *
 * TC : O(n) + O(q x log(n)) + O(q x log(n)) ~ O(n + q x log(n))
 *      - O(n) for Segment Tree construction
 *      - O(q x log(n)) for 'update' queries
 *      - O(q x log(n)) for 'sumRange' queries
 * SC : O(n) + O(log(n))
 *      - O(n + log(n)) for Segment Tree construction
 *      - O(log(n)) for 'update' queries
 *      - O(log(n)) for 'sumRange' queries
 */
class NumArray {
    private int n;
    private int[] nums;
    private int[] segTree;

    /**
     * Using Segment Tree Approach
     *
     * TC : O(n)
     * SC : O(n) + O(log(n))
     */
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.segTree = new int[4 * n]; // SC : O(4 x n)
        buildSegmentTree(0, n - 1, 0); // TC : O(n), SC : O(log(n))
    }
    
    /**
     * Using Segment Tree Approach
     *
     * TC : O(log(n))
     * SC : O(log(n))
     */
    public void update(int index, int val) {
        updateSegmentTree(index, val, 0, n - 1, 0);
    }
    
    /**
     * Using Segment Tree Approach
     *
     * TC : O(log(n))
     * SC : O(log(n))
     */
    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }

    /**
     * Using Segment Tree Approach
     *
     * TC : O(log(n))
     * SC : O(log(n))
     */
    private int querySegmentTree(int start, int end, int idx, int l, int r) {
        // Base Case
        // Case 1 : Out of Bound Range
        if (end < l || start > r) {
            return 0;
        }
        // Case 2 : Full Overlap Range
        if (l >= start && r <= end) {
            return segTree[idx];
        }
        // Recursion Calls
        int mid = l + (r - l) / 2;
        int leftSum = querySegmentTree(start, end, 2 * idx + 1, l, mid);
        int rightSum = querySegmentTree(start, end, 2 * idx + 2, mid + 1, r);
        return leftSum + rightSum;
    }

    /**
     * Using Segment Tree Approach
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
     * Using Segment Tree Approach
     *
     * TC : O(log(n))
     * SC : O(log(n))
     */
    private void updateSegmentTree(int index, int val, int l, int r, int idx) {
        // Base Case
        if (l == r) {
            segTree[idx] = val;
            return;
        }
        // Recursion Calls
        int mid = l + (r - l) / 2;
        if (index <= mid) {
            updateSegmentTree(index, val, l, mid, 2 * idx + 1);
        } else {
            updateSegmentTree(index, val, mid + 1, r, 2 * idx + 2);
        }
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
