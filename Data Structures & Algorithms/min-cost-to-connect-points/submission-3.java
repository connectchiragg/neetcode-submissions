class Solution {
    public int minCostConnectPoints(int[][] points) {
        int result = 0;
        int[] dist = new int[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        int latestNode = 0; // we can start from any node

        for(int i = 0; i < points.length; i++){
            int minDist = Integer.MAX_VALUE;
            int closestNode = -1;
            for(int j = 0; j < points.length; j++){
                if(dist[j] == 0) continue;
                dist[j] = Math.min(dist[j], distance(points[latestNode], points[j]));

                if(dist[j] < minDist){
                    minDist = dist[j];
                    closestNode = j;
                }
            }
            latestNode = closestNode;
            dist[latestNode] = 0;
            result += minDist;
        }

        return result;
    }

    private int distance(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
