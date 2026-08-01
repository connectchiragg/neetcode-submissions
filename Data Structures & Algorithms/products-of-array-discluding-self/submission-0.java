class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        int[] result = new int[n];
        int p = 1;

        for(int i = 0; i < n; i++){
            prefix[i] = p;
            p *= nums[i];
        }

        p = 1;

        for(int i = n - 1; i >= 0; i--){
            suffix[i] = p;
            p *= nums[i];
        }

        for(int i = 0; i < n; i++){
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  
