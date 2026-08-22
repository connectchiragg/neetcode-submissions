class Solution {
    public int minCostConnectPoints(int[][] points) {
        int result = 0;
        int[] dist = new int[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        Set<Integer> pointsSet = new HashSet<>();

        for(int i = 1; i < points.length; i++){
            pointsSet.add(i);
        }
        
        int curr = 0;

        while(!pointsSet.isEmpty()){
            int minDist = Integer.MAX_VALUE;
            int closestNode = -1;
            for(int i : pointsSet){
                dist[i] = Math.min(dist[i], distance(points[curr], points[i]));

                if(dist[i] < minDist){
                    minDist = dist[i];
                    closestNode = i;
                }
            }
            curr = closestNode;
            pointsSet.remove(curr);
            result += minDist;
        }

        return result;
    }

    private int distance(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
