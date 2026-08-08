class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // using the smaller array as num1 - reserved for binary search
        if(nums2.length < nums1.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int n1 = nums1.length, n2 = nums2.length;
        boolean isEven = ((n1 + n2) % 2 == 0);
        int half = (n1 + n2 + 1) / 2;

        int low = 0, high = n1;

        while(low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = half - mid1;

            int left1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right1 = mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE;
            int right2 = mid2 < n2 ? nums2[mid2] : Integer.MAX_VALUE;

            if(left1 > right2){
                high = mid1 - 1;
            } else if(left2 > right1){
                low = mid1 + 1;
            } else {
                return isEven ? (
                    Math.max(left1, left2) + Math.min(right1, right2)) / 2.0
                    : 
                    Math.max(left1, left2);
            }
        }

        return -1;
    }
}
