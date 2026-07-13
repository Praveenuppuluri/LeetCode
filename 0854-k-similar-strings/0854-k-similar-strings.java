import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(s1);
        visited.add(s1);
        
        int swaps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(s2)) {
                    return swaps;
                }
                
                int j = 0;
                while (j < current.length() && current.charAt(j) == s2.charAt(j)) {
                    j++;
                }
                
                char[] currArray = current.toCharArray();
                for (int k = j + 1; k < current.length(); k++) {
                    if (currArray[k] == s2.charAt(j) && currArray[k] != s2.charAt(k)) {
                        swap(currArray, j, k);
                        String nextString = new String(currArray);
                        if (visited.add(nextString)) {
                            queue.offer(nextString);
                        }
                        swap(currArray, j, k);
                    }
                }
            }
            swaps++;
        }
        
        return swaps;
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}