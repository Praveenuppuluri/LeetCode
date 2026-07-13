import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
        // Base case: If we've reached the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Explore all possible substrings starting from the current 'start' index
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                // If it's a palindrome, add it to our current path
                currentList.add(s.substring(start, i + 1));
                
                // Recursively explore the rest of the string
                backtrack(s, i + 1, currentList, result);
                
                // Backtrack: remove the last added palindrome to try the next one
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    // Helper method to check if a substring is a palindrome
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}