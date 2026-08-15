class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(k > n){
            // invalid test case
            return -1;
        }

        int end = n - 1;
        int start = 0;
        int curr = 0;
        int pivot = 0;

        while(true){
            for(curr = start; curr < end; curr++){
                if(nums[curr] >= nums[end]){
                    bubbleUp(nums, pivot, curr);
                    pivot++;
                }
            }

            swap(nums, pivot, end);
            if(pivot == k - 1) break;
            if(pivot < k - 1){
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
            pivot = start;
        }

        return nums[pivot];
    }

    private void bubbleUp(int[] nums, int a, int b){
        while(b > a){
            swap(nums, b, b - 1);
            b--;
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}