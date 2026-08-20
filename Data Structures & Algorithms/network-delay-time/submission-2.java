record Edge(int end, int dist){}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
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

        dfs(graph, k - 1, dist, 0);

        for(int i = 0; i < n; i++){
            result = Math.max(result, dist[i]);
            if(result == Integer.MAX_VALUE) return -1;
        }

        return result;
    }

    private void dfs(List<Edge>[] graph, int k, int[] dist, int curr){
        if(graph[k] == null) return;
        if(curr >= dist[k]) return;
        
        List<Edge> neighbors = graph[k];
        dist[k] = Math.min(dist[k], curr);
        graph[k] = null;

        for(Edge edge : neighbors){
            dfs(graph, edge.end(), dist, curr + edge.dist());
        }

        graph[k] = neighbors;
    }
}
