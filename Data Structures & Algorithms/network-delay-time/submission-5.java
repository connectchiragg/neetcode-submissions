record Edge(int end, int dist){}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.dist(), e2.dist()));
        List<Edge>[] graph = new List[n];
        int[] dist = new int[n];
        int result = 0;

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] time : times){
            graph[time[0] - 1].add(new Edge(time[1] - 1, time[2]));
        }

        pq.add(new Edge(k - 1, 0));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int end = curr.end();
            int distance = curr.dist();

            dist[end] = Math.min(dist[end], distance);
            
            for(Edge edge : graph[end]){
                pq.add(new Edge(edge.end(), edge.dist() + distance));
            }
            graph[end] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            result = Math.max(result, dist[i]);
            if(result == Integer.MAX_VALUE) return -1;
        }

        return result;
    }
}
