class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(amount, coins, dp, 0);
    }

    private int solve(int amount, int[] coins, int[][] dp, int idx){
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(idx == coins.length) return 0;
        if(dp[amount][idx] != -1) return dp[amount][idx];
        dp[amount][idx] = 0;

        for(int i = 0; i <= amount / coins[idx]; i++){
            dp[amount][idx] += solve(amount - (i * coins[idx]), coins, dp, idx + 1);
        }

        return dp[amount][idx];
    }
}
