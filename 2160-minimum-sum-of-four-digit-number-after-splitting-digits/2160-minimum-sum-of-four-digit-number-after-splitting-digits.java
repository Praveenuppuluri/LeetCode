class Solution {
    public int minimumSum(int num) {
        // Extract the four digits
        int[] digits = new int[4];
        digits[0] = num % 10;
        digits[1] = (num / 10) % 10;
        digits[2] = (num / 100) % 10;
        digits[3] = num / 1000;
        
        // Sort the digits in ascending order
        Arrays.sort(digits);
        
        // To minimize the sum, the smallest digits must be placed in the tens place, 
        // and the larger digits in the ones place.
        int num1 = digits[0] * 10 + digits[2];
        int num2 = digits[1] * 10 + digits[3];
        
        return num1 + num2;
    }
}