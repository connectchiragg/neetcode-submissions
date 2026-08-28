class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(Math.abs(target) > sum) return 0;

        target += sum;

        if(target % 2 != 0) return 0;

        target /= 2;

        int[][] dp = new int[nums.length + 1][target + 1];
        
        dp[0][0] = 1;
        for(int i = 1; i <= nums.length; i++){
            int num = nums[i - 1];
            for(int j = 0; j <= target; j++){
                dp[i][j] += dp[i - 1][j] + (j >= num ? dp[i - 1][j - num] : 0);
            }
        }
        return dp[nums.length][target];
    }
}
