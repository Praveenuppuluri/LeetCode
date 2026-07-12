class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currMax = 0;
        int maxSum = nums[0];
        int currMin = 0;
        int minSum = nums[0];

        for (int x : nums) {
            totalSum += x;
            
            currMax = Math.max(currMax + x, x);
            maxSum = Math.max(maxSum, currMax);
            
            currMin = Math.min(currMin + x, x);
            minSum = Math.min(minSum, currMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}