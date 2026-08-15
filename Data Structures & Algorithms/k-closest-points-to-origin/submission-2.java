class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        if(k > n){
            // invalid use case
            return points;
        }

        int[][] result = new int[k][2];

        int start = 0;
        int end = n - 1;
        int pivot;

        while(true){
            pivot = start;
            int random = start + (int)(Math.random() * (end - start + 1));
            swap(points, random, end);

            for(int curr = start; curr != end; curr++){
                if(distance(points[curr]) <= distance(points[end])){
                    swap(points, pivot, curr);
                    pivot++;
                }
            }

            swap(points, pivot, end);

            if(pivot == k - 1) break;
            if(pivot < k - 1){
                start = pivot + 1;
            } else{
                end = pivot - 1;
            }
        }

        for(int i = 0; i <= pivot; i++){
            result[i] = points[i];
        }

        return result;
    }

    private void swap(int[][] points, int a, int b){
        int[] tempPoint = points[a];
        points[a] = points[b];
        points[b] = tempPoint;
    }

    private double distance(int[] point){
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
