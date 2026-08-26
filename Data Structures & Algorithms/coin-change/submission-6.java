class Solution {
    public int coinChange(int[] coins, int amount) {
        int window = 0;
        for(int coin : coins){
            window = Math.max(window, coin);
        }
        
        window = Math.min(window, amount);
        window++;

        int[] dp = new int[window];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            int i1 = i % window;
            dp[i1] = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i < coin) continue;
                int j1 = (i - coin) % window;
                if(dp[j1] != Integer.MAX_VALUE){
                    dp[i1] = Math.min(dp[i1], dp[j1] + 1);
                }
            }

            System.out.println(i + "->" + i1 + "=" + dp[i1]);
        }

        return dp[amount % window] == Integer.MAX_VALUE ? -1 : dp[amount % window];
    }
}
