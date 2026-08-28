class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(Math.abs(target) > sum) return 0;

        int[][] dp = new int[2 * sum + 1][nums.length + 1];

        dp[sum][0] = 1;

        for(int j = 1; j <= nums.length; j++){
            int num = nums[j - 1];
            for(int i = -sum; i <= sum; i++){
                if(i - num + sum >= 0){
                    dp[i + sum][j] += dp[i - num + sum][j - 1];
                }

                if(i + num + sum <= 2 * sum){
                    dp[i + sum][j] += dp[i + num + sum][j - 1];
                }
            }
        }

        return dp[target + sum][nums.length];
    }
}
