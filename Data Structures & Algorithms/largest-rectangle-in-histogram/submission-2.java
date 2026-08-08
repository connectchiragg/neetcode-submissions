class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] results = new int[n];

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                results[stack.peek()] += heights[stack.peek()] * (i - stack.peek() - 1);
                result = Math.max(result, results[stack.peek()]);
                stack.pop();
            }

            int start = stack.isEmpty() ? -1 : stack.peek();

            results[i] = heights[i] * (i - start);
            result = Math.max(result, results[i]);
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int curr = stack.pop();
            results[curr] += heights[curr] * (n - curr - 1);
            result = Math.max(result, results[curr]);
        }

        return result;
    }
}
