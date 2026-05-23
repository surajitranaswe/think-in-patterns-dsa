class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC : O(m x n)
     * SC : O(1)
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int p = 0; // pointer at the start of String 'haystack'
        int q = 0; // pointer at the start of String 'needle'
        while (p < m) { // TC : O(m)
            if (haystack.charAt(p) == needle.charAt(q)) {
                p++;
                q++;
                if (q == n) {
                    return p - n;
                }
            } else {
                p = p - q + 1;
                q = 0; // reset pointer of String 'needle'
            }
        }
        return -1;
    }
}
