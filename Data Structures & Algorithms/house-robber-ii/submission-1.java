class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int first = 0, second = 0, result1 = 0, result2 = 0;

        for(int i = 0; i < nums.length - 1; i++){
            result1 = Math.max(second, nums[i] + first);

            first = second;
            second = result1;
        }

        first = 0;
        second = 0;

        for(int i = 1; i < nums.length; i++){
            result2 = Math.max(second, nums[i] + first);

            first = second;
            second = result2;
        }

        return Math.max(result1, result2);
    }
}
