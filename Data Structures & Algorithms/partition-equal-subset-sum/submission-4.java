class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, curr = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false;

        sum /= 2;
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int num : nums){
            for(int i = sum - num; i >= 0; i--){
                if(!dp[i]) continue;
                dp[i + num] = true;
            }
        }

        return dp[sum];
    }
}
