class Solution {
    public int maxSubArray(int[] nums) {
        int curr = nums[0], result = nums[0];

        for(int i = 1; i < nums.length; i++){
            curr = Math.max(curr + nums[i], nums[i]);
            result = Math.max(result, curr);
        }

        return result;
    }
}
