/**
 * The Solution class provides a method to count the number of distinct subsequences
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
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the dp array: forming an empty t from any s is always 1 way (by deleting all characters)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp array using bottom-up dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // include or exclude current char
                } else {
                    dp[i][j] = dp[i - 1][j]; // exclude current char
                }
            }
        }

        return dp[m][n];
    }
}
