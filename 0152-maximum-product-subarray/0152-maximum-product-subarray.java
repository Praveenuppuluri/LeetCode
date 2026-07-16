class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Initialize max, min, and the overall result with the first element
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            // Store the current max temporarily so we don't overwrite it 
            // before calculating the new minSoFar
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            
            // Update maxSoFar
            maxSoFar = tempMax;
            
            // Update the overall maximum product found so far
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
}