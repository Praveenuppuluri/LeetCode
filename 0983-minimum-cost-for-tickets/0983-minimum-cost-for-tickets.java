class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // The last day we need to travel
        int lastDay = days[days.length - 1];
        
        // dp[i] stores the minimum cost to travel up to day i
        int[] dp = new int[lastDay + 1];
        
        // Use a boolean array to easily check if a day is a travel day
        boolean[] isTravelDay = new boolean[lastDay + 1];
        for (int day : days) {
            isTravelDay[day] = true;
        }
        
        for (int i = 1; i <= lastDay; i++) {
            // If we don't travel on day i, the cost is the same as day i-1
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            
            // If we buy a 1-day pass today
            int cost1 = dp[i - 1] + costs[0];
            
            // If we buy a 7-day pass ending today (cannot look back past day 0)
            int cost7 = dp[Math.max(0, i - 7)] + costs[1];
            
            // If we buy a 30-day pass ending today (cannot look back past day 0)
            int cost30 = dp[Math.max(0, i - 30)] + costs[2];
            
            // Take the minimum of all three choices
            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }
        
        return dp[lastDay];
    }
}