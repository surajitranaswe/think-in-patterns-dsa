class Solution {
    /**
     * Approach : Using KMP Algorithm Approach
     *
     * TC : O(n) + O(n) ~ O(n)
     * SC : O(n) + O(n) ~ O(n)
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        Set<Integer> lpsSet = computeLPSArray(s, n); // TC : O(n), SC : O(n)
        StringBuilder sb = new StringBuilder(); // SC : O(n)
        for (Integer lps : lpsSet) {            // TC : O(k)
            String sub = s.substring(0, lps);   // SC : O(k)
            sb.setLength(0);
            int times = n / lps;
            int j = 0;
            while (j < times) { // TC : O(n / k)
                sb.append(sub);
                j++;
            }
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Using KMP Algorithm for LPS Array Approach
     *
     * TC : O(n)
     * SC : O(n) + O(k) ~ O(n)
     */
    private Set<Integer> computeLPSArray(String s, int n) {
        int[] lps = new int[n]; // SC : O(n)
        Set<Integer> lpsSet = new HashSet<>(); // SC : O(k)
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) { // TC : O(n)
            if (s.charAt(len) == s.charAt(i)) {
                len++;
                lps[i] = len;
                if (lps[i] > 0) {
                    lpsSet.add(lps[i]);
                }
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
        return lpsSet;
    }
}
