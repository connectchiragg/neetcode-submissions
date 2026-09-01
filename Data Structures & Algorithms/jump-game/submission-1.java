class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        nums[0] = -nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                for(int j = i + 1; j < nums.length && j <= i + Math.abs(nums[i]); j++){
                    if(j == nums.length - 1) return true;
                    nums[j] = -Math.abs(nums[j]);
                }
            }
        }

        return false;
    }
}
