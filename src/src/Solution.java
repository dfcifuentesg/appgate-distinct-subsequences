/**
 * The Solution class provides methods to count the number of distinct subsequences
 * of a string s that equal another string t using dynamic programming.
 */
public class Solution {

    /**
     * Calculates the number of distinct subsequences of s which equal t.
     *
     * @param s the source string
     * @param t the target string
     * @return the number of distinct subsequences
     */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = initializeDP(m, n);
        fillDPTable(s, t, dp, m, n);
        return dp[m][n];
    }

    /**
     * Initializes the dp array and sets the base cases.
     *
     * @param m length of string s
     * @param n length of string t
     * @return initialized dp array
     */
    private int[][] initializeDP(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; // An empty t can always be formed from s by deleting all characters
        }
        return dp;
    }

    /**
     * Fills the dp table using bottom-up dynamic programming.
     *
     * @param s the source string
     * @param t the target string
     * @param dp the dp array
     * @param m length of string s
     * @param n length of string t
     */
    private void fillDPTable(String s, String t, int[][] dp, int m, int n) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // include or exclude current char
                } else {
                    dp[i][j] = dp[i - 1][j]; // exclude current char
                }
            }
        }
    }
}
