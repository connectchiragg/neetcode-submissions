class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = 0, second = 0, curr = Math.min(cost[0], cost[1]);
        
        for(int i = 2; i <= cost.length; i++){
            curr = Math.min(first + cost[i - 2], second + cost[i - 1]);
            first = second;
            second = curr;
        }

        return curr;
    }
}
