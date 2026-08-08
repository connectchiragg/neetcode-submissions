class Solution {
    public int search(int[] nums, int target) {
        return pivotSearch(nums, 0, nums.length - 1, target);
    }

    private int pivotSearch(int[] nums, int low, int high, int target){
        if(low > high) return -1;
        int mid = low + (high - low) / 2;

        if(nums[mid] == target) return mid;

        if(nums[mid] >= nums[low] && target < nums[mid] && target >= nums[low]){
            // target search in left sorted part
            return sortedSearch(nums, low, mid - 1, target);
        } else if(nums[mid] >= nums[low]) {
            // target search in right pivoted part
            return pivotSearch(nums, mid + 1, high, target);
        } else if(nums[mid] < nums[low] && target > nums[mid] && target <= nums[high]){
            // target search in right sorted part
            return sortedSearch(nums, mid + 1, high, target);
        } else {
            // target search in left pivoted part
            return pivotSearch(nums, low, mid - 1, target);
        }
    }

     private int sortedSearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target > nums[mid]){
                low = mid + 1;
            } else if(target < nums[mid]){
                high = mid - 1;
            } else return mid;
        }

        return -1;
    }
}
