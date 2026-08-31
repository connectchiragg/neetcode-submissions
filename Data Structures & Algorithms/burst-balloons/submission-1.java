class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(dp, nums, -1, nums.length);
    }

    private int solve(int[][] dp, int[] nums, int low, int high){
        if(dp[low + 1][high] != -1) return dp[low + 1][high];

        int result = 0;

        for(int i = low + 1; i < high; i++){
            int cost = (low >= 0 ? nums[low] : 1) * nums[i] * (high < nums.length ? nums[high] : 1);
            result = Math.max(result, solve(dp, nums, low, i) + cost + solve(dp, nums, i, high));
        }

        return dp[low + 1][high] = result;
    }
}
