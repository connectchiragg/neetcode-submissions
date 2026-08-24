class Solution {
    public int rob(int[] nums) {
        int first = 0, second = 0, third = 0, curr = 0, result = 0;

        for(int i = 0; i < nums.length; i++){
            curr = nums[i] + Math.max(first, second);

            result = Math.max(result, curr);

            first = second;
            second = third;
            third = result;
        }

        return result;
    }
}
