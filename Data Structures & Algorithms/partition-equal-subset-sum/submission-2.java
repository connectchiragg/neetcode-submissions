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
            List<Integer> set = new ArrayList<>();
            for(int i = 0; i <= sum - num; i++){
                if(!dp[i]) continue;
                set.add(i + num);
            }

            for(int i : set){
                dp[i] = true;
            }
        }

        return dp[sum];
    }
}
