import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Lists to store subset sums for the left and right halves.
        // Index 'k' represents the number of elements picked from that half.
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        
        // Generate all subset sums using bitmasking
        int totalSubsets = 1 << n; // 2^n
        for (int mask = 0; mask < totalSubsets; mask++) {
            int leftSum = 0;
            int rightSum = 0;
            int count = 0; // Number of elements picked (set bits)
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    leftSum += nums[i];
                    rightSum += nums[i + n];
                    count++;
                }
            }
            left.get(count).add(leftSum);
            right.get(count).add(rightSum);
        }
        
        // Sort the right arrays so we can perform binary search on them
        for (int i = 0; i <= n; i++) {
            Collections.sort(right.get(i));
        }
        
        int minDiff = Integer.MAX_VALUE;
        int target = totalSum / 2;
        
        // Pick k elements from the left half, meaning we need (n - k) from the right half
        for (int k = 0; k <= n; k++) {
            List<Integer> leftArr = left.get(k);
            List<Integer> rightArr = right.get(n - k);
            
            for (int a : leftArr) {
                int t = target - a; // The ideal value we want from the right half
                
                // Binary search for the closest value to 't' in rightArr
                int idx = Collections.binarySearch(rightArr, t);
                if (idx < 0) {
                    idx = -(idx + 1); // Get the insertion point if not found
                }
                
                // Check the element at the insertion point (closest larger or equal)
                if (idx < rightArr.size()) {
                    int b = rightArr.get(idx);
                    int currentSum = a + b;
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * currentSum));
                }
                
                // Check the element right before the insertion point (closest smaller)
                if (idx > 0) {
                    int b = rightArr.get(idx - 1);
                    int currentSum = a + b;
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * currentSum));
                }
            }
        }
        
        return minDiff;
    }
}