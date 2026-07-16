class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] represents the minimum operations to convert 
        // the first i characters of word1 to the first j characters of word2
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: converting word1 to an empty word2 requires i deletions
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        
        // Base case: converting an empty word1 to word2 requires j insertions
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill out the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, no new operation is needed
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // If they don't match, take the minimum of the 3 possible operations + 1
                else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // Replace
                        Math.min(
                            dp[i - 1][j], // Delete
                            dp[i][j - 1]  // Insert
                        )
                    );
                }
            }
        }
        
        return dp[m][n];
    }
}