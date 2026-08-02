class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int result = 0;

        while(i < j){
            result = Math.max(result, area(heights, i, j));

            if(heights[i] < heights[j]){
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    private int area(int[] heights, int i, int j){
        return (j - i) * Math.min(heights[i], heights[j]);
    }
}
