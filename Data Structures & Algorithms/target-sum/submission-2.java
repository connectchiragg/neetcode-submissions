class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int prefixSum = 0;

        for(int num : nums){
            sum += num;
        }

        if(Math.abs(target) > sum) return 0;

        int[] dp = new int[2 * sum + 1];

        dp[sum] = 1;

        for(int j = 1; j <= nums.length; j++){
            int num = nums[j - 1];
            prefixSum += num;
            int[] temp = new int[dp.length];
            for(int i = -prefixSum; i <= prefixSum; i++){
                if(i - num + sum >= 0){
                    temp[i + sum] += dp[i - num + sum];
                }

                if(i + num + sum <= 2 * sum){
                    temp[i + sum] += dp[i + num + sum];
                }
            }

            dp = temp;
        }

        return dp[target + sum];
    }
}
