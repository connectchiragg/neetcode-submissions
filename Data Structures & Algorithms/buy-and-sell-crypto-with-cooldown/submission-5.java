class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, prev = 0, superPrev = 0;
        int sell = 0;

        for(int i = prices.length - 1; i >= 0; i--){
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, prices[i] + superPrev);
            superPrev = prev;
            prev = buy;
        }

        return buy;
    }
}
