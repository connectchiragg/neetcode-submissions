class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0; i <= k; i++){
            int[] next = dist.clone();
            for(int[] flight : flights){
                if(dist[flight[0]] != Integer.MAX_VALUE){
                    next[flight[1]] = Math.min(next[flight[1]], dist[flight[0]] + flight[2]);
                }
            }
            dist = next.clone();
        }

        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}
