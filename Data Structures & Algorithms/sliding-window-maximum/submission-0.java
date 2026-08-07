class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;

        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);

            if((i - j + 1) == k){
                result[j] = pq.peek();
                pq.remove(nums[j]);
                j++;
            }
        }

        return result;
    }
}
