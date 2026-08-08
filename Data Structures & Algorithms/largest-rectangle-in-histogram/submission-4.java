class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int curr = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                int width = right - left - 1;
                result = Math.max(result, heights[curr] * width);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int curr = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int right = n;

            int width = right - left - 1;
            result = Math.max(result, heights[curr] * width);
        }

        return result;
    }
}
