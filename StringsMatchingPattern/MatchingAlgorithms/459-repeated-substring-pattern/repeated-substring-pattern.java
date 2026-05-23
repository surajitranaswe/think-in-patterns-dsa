class Solution {
    /**
     * Approach : Using KMP Algorithm Approach
     *
     * TC : O(n) + O(n x k) ~ O(n x k)
     * SC : O(n)
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n]; // SC : O(n)
        computeLPSArray(s, n, lps);   // TC : O(n), SC : O(1)
        for (int i = 0; i < n; i++) { // TC : O(n)
            if (lps[i] > 0) {
                String sub = s.substring(0, lps[i]);
                int len = lps[i];
                int times = n / len;
                int j = 0;
                StringBuilder sb = new StringBuilder();
                while (j < times) {
                    sb.append(sub);
                    j++;
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Using KMP Algorithm for LPS Array Approach
     *
     * TC : O(n)
     * SC : O(1)
     */
    private void computeLPSArray(String s, int n, int[] lps) {
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(len) == s.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
    }
}
