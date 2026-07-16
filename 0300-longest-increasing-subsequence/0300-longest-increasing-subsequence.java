class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // dp[i] represents the length of the longest increasing subsequence ending at index i
        int[] dp = new int[nums.length];
        int maxLength = 1;
        
        // Every element is an increasing subsequence of length 1 on its own
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // If we find a strictly smaller previous element, we can append nums[i] to its subsequence
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Keep track of the maximum length found so far
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}