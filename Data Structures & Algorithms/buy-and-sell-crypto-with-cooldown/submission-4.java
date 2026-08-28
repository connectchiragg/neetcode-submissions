class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length + 2];
        int[] sell = new int[prices.length + 2];

        for(int i = prices.length - 1; i >= 0; i--){
            buy[i] = Math.max(buy[i + 1], sell[i + 1] - prices[i]);
            sell[i] = Math.max(sell[i + 1], prices[i] + buy[i + 2]); 
        }

        return buy[0];
    }
}
