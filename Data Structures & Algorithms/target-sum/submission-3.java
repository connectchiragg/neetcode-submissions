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

            for(int num : nums){
                int[] temp = new int[dp.length];
                for(int i = -prefixSum; i <= prefixSum; i++){
                    int ways = dp[i + sum];
                    if(ways == 0) continue;

                    temp[i + sum + num] += ways;
                    temp[i + sum - num] += ways;
                }
                prefixSum += num;
                dp = temp;
            }

            return dp[target + sum];
        }
    }
