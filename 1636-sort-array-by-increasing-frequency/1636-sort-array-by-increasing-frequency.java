import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }
        
        Arrays.sort(numsObj, (a, b) -> {
            int freqA = count.get(a);
            int freqB = count.get(b);
            if (freqA == freqB) {
                return b - a;
            }
            return freqA - freqB;
        });
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }
        
        return nums;
    }
}