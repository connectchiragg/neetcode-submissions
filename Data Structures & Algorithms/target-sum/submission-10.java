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

        int[] dp = new int[target + 1];
        
        dp[0] = 1;
        for(int num : nums){
            for(int j = target; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
