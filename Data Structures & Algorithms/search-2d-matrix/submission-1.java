class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix.length, height = matrix[0].length;
        int low = 0, high = (width * height) - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int value = getValue(matrix, mid);

            if(value < target){
                low = mid + 1;
            } else if(value > target){
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private int getValue(int[][] matrix, int idx){
        int width = matrix[0].length;
        return matrix[idx / width][idx % width];
    }
}