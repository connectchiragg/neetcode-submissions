class Solution {
    public int rob(int[] nums) {
        int first = 0, second = 0, curr = 0;

        for(int num : nums){
            curr = Math.max(second, num + first);

            first = second;
            second = curr;
        }

        return curr;
    }
}
