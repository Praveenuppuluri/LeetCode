class Solution {
    public String frequencySort(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            int max = 0;
            int idx = 0;
            for (int i = 0; i < 128; i++) {
                if (count[i] > max) {
                    max = count[i];
                    idx = i;
                }
            }
            while (count[idx] > 0) {
                sb.append((char) idx);
                count[idx]--;
            }
        }
        
        return sb.toString();
    }
}