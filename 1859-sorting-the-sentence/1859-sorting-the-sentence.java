class Solution {
    public String sortSentence(String s) {
        // Split the sentence into an array of words
        String[] words = s.split(" ");
        String[] result = new String[words.length];
        
        for (String word : words) {
            // Get the position from the last character of the word (1-indexed)
            int index = word.charAt(word.length() - 1) - '0';
            
            // Get the actual word without the number
            String actualWord = word.substring(0, word.length() - 1);
            
            // Place the word in its correct 0-indexed position in the result array
            result[index - 1] = actualWord;
        }
        
        // Join the sorted words back into a single sentence separated by spaces
        return String.join(" ", result);
    }
}