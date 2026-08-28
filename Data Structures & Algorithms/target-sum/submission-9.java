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
            int[] next = new int[dp.length];
            for(int j = 0; j <= target; j++){
                next[j] += dp[j] + (j >= num ? dp[j - num] : 0);
            }
            dp = next;
        }
        return dp[target];
    }
}
