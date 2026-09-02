class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE, curr = 0, result = -1;

        for(int i = 0; i < gas.length; i++){
            curr += gas[i] - cost[i];
            if(curr < min){
                min = curr;
                result = (i + 1) % gas.length;
            }
        }

        return curr >= 0 ? result : -1;
    }
}