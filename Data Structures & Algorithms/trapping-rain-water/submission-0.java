class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        int result = 0;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        for(int i = 1; i < n; i++){
            prefix[i] = Math.max(prefix[i - 1], heights[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--){
            suffix[i] = Math.max(suffix[i + 1], heights[i + 1]);
        }

        for(int i = 0; i < n; i++){
            result += Math.max(Math.min(prefix[i], suffix[i]) - heights[i], 0);
        }

        return result;
    }
}
