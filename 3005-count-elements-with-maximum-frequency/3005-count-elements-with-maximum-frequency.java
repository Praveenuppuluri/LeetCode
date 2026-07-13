class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int maxFreq = 0;
        for (int num : nums) {
            count[num]++;
            maxFreq = Math.max(maxFreq, count[num]);
        }
        
        int totalFrequency = 0;
        for (int f : count) {
            if (f == maxFreq) {
                totalFrequency += f;
            }
        }
        
        return totalFrequency;
    }
}