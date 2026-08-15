class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(k > n){
            // invalid test case
            return -1;
        }

        int end = n - 1;
        int start = 0;

        while(true){
            int pivot = start;
            for(int curr = start; curr < end; curr++){
                if(nums[curr] >= nums[end]){
                    swap(nums, pivot, curr);
                    pivot++;
                }
            }

            swap(nums, pivot, end);
            if(pivot == k - 1) return nums[pivot];
            if(pivot < k - 1){
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}