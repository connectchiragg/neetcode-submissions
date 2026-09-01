class Solution {
    public int jump(int[] nums) {
        int farthest = 0, right = 0, jumps = 0;

        for(int i = 0; i < nums.length; i++){

            if(i > right){
                jumps++;
                right = farthest;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }

        return jumps;
    }
}