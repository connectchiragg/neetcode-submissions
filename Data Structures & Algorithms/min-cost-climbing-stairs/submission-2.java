class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = 0, second = 0, curr = -1;
        
        for(int i = 2; i <= cost.length; i++){
            curr = Math.min(first + cost[i - 2], second + cost[i - 1]);
            first = second;
            second = curr;
        }

        return curr;
    }
}
