class Solution {
    /**
     * Approach II : Using KMP Algorithm + Two Pointers Approach
     *
     * TC : O(m + n)
     * SC : O(n)
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        int[] lps = new int[n];          // SC : O(n)
        computeLPSArray(needle, n, lps); // TC : O(n)
        // Using Two-Pointers Approach
        int i = 0; // pointer at the start of String 'haystack'
        int j = 0; // pointer at the start of String 'needle'
        while (i < m) { // TC : O(m)
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return (i - n);
                }
            } else {
                // pointers do not match we need to fallback 'j' to a better index
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    /**
     * Using KMP Algorithm to compute LPS Array Approach
     *
     * TC : O(n)
     * SC : O(1)
     */
    private void computeLPSArray(String p, int n, int[] lps) {
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (p.charAt(len) == p.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // we need to fallback 'len' to a better index
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
    }

    /**
     * Approach I : Using Brute-Force (Two Pointers) Approach
     *
     * TC : O(m x n)
     * SC : O(1)
     */
    public int strStrBruteForce(String haystack, String needle) {
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
