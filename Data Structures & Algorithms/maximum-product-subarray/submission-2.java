class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1, result = Integer.MIN_VALUE;

        for(int i : nums){
            int currMax = Math.max(i, Math.max(min * i, max * i));
            int currMin = Math.min(i, Math.min(min * i, max * i));
            max = currMax;
            min = currMin;

            result = Math.max(result, max);
        }
        
        return result;
    }
}