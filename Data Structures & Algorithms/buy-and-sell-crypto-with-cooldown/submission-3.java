class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];

        for(int i = prices.length - 1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                dp[j] = Math.max(Math.max(dp[j + 1], dp[j]), prices[i] - prices[j] + 
                        (i + 2 < prices.length ? dp[i + 2] : 0));
            }
        }

        // i = selling point, j = buying point, dp[x] = max benefit starting from here

        return dp[0];
    }
}
