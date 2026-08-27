class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false;

        sum /= 2;
        Boolean[][] dp = new Boolean[sum + 1][nums.length];

        return solve(nums, sum, 0, dp);
    }
    
    private boolean solve(int[] nums, int sum, int i, Boolean[][] dp){
        if(sum < 0) return false;
        if(sum == 0) return true;
        if(i == nums.length) return false;
        if(dp[sum][i] != null) return dp[sum][i];

        return dp[sum][i] = solve(nums, sum, i + 1, dp) || solve(nums, sum - nums[i], i + 1, dp);
    }
}
