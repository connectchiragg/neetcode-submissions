class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;

        if(n == 0) return result;

        int minPrice = prices[0];

        for(int i : prices){
            result = Math.max(result, i - minPrice);
            minPrice = Math.min(minPrice, i);
        }

        return result;
    }
}
