class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for(int right = 0; right < nums.length; right++){
            while(!deque.isEmpty() && nums[deque.peekFirst()] <= nums[right]){
                deque.pollFirst();
            }

            deque.addFirst(right);

            while(!deque.isEmpty() && (right - deque.peekLast() + 1) > k ){
                deque.pollLast();
            }

            if(right >= k - 1){
                result[right - k + 1] = nums[deque.peekLast()];
            }
        }

        return result;
    }
}
