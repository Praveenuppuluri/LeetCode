class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        // Loop through the prices starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // If the price increased from the previous day, capture that profit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}