class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = -1;

        for(int j = n / 2; j > 0; j /= 2){      // j for 'jump'
            while(start + j < n && nums[start + j] > nums[n - 1]){
                start += j;
            }
        }

        return n > 0 ? nums[start + 1] : 0;
    }
}
