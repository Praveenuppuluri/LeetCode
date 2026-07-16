class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] represents if the first i characters of s 
        // match the first j characters of p.
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Base case: empty string can only match a pattern of just '*'s
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                
                // Case 1: Characters match directly, or pattern has a '?'
                if (sChar == pChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // Case 2: Pattern has a '*'
                else if (pChar == '*') {
                    // '*' matches empty sequence (dp[i][j-1]) OR 
                    // '*' matches one or more characters (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}