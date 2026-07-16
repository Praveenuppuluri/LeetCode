class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int maxLength = 0;
        
        // dp[i][j] represents the maximum length of a repeated subarray 
        // that ends at nums1[i-1] and nums2[j-1].
        int[][] dp = new int[m + 1][n + 1];
        
        // Iterate through both arrays
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the elements match, add 1 to the length of the matching subarray 
                // that ended at the previous indices
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
                // (Optional) Else block is not needed since the default value in Java int arrays is 0,
                // which correctly represents the streak breaking.
            }
        }
        
        return maxLength;
    }
}