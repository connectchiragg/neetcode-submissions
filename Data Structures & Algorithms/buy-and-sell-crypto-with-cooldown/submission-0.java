class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return solve(prices, 0, dp);
    }

    private int solve(int[] prices, int i, int[] dp){
        if(i >= prices.length) return 0;
        if(dp[i] != -1) return dp[i];

        int result = 0;

        for(int j = i; j < prices.length - 1; j++){
            for(int k = j + 1; k < prices.length; k++){
                result = Math.max(result, prices[k] - prices[j] + solve(prices, k + 2, dp));
            }
        }

        return dp[i] = result;
    }
}
