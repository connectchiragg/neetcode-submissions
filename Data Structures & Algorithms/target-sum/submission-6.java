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

        int[][] dp = new int[target + 1][nums.length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(dp, nums, target, 0);
    }

    private int solve(int[][] dp, int[] nums, int target, int i){
        if(target < 0) return 0;
        if(i == nums.length){
            if(target == 0) return 1;
            return 0;
        }

        if(dp[target][i] != -1) return dp[target][i];

        return dp[target][i] = solve(dp, nums, target, i + 1) + solve(dp, nums, target - nums[i], i + 1);
    }
}
