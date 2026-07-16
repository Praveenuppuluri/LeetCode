class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the absolute target is greater than the sum of all elements, 
        // or if (target + totalSum) is odd, it's impossible to reach the target.
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }
        
        // This is the target sum we need to find subsets for
        int subsetSum = (totalSum + target) / 2;
        
        // dp[i] represents the number of ways to reach sum i
        int[] dp = new int[subsetSum + 1];
        
        // There is 1 way to reach a sum of 0 (by choosing no elements)
        dp[0] = 1;
        
        for (int num : nums) {
            // We iterate backward to avoid reusing the same number in the current step
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[subsetSum];
    }
}