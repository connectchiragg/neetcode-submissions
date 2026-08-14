class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(distance(points[b]), distance(points[a]))
        );

        int[][] result = new int[k][2];

        for(int i = 0; i < points.length; i++){
            pq.add(i);

            if(pq.size() > k){
                pq.poll();
            }
        }

        for(int i = 0; i < k; i++){
            result[i] = points[pq.poll()];
        }

        return result;
    }

    private double distance(int[] point){
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
