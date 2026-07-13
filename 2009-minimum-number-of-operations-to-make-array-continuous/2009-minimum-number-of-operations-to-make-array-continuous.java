import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int uniqueLen = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueLen++] = nums[i];
            }
        }
        
        int minOps = n;
        int j = 0;
        
        for (int i = 0; i < uniqueLen; i++) {
            while (j < uniqueLen && nums[j] < nums[i] + n) {
                j++;
            }
            minOps = Math.min(minOps, n - (j - i));
        }
        
        return minOps;
    }
}