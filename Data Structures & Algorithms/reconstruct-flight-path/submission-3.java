class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), v -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs(result, graph, "JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(List<String> result, Map<String, PriorityQueue<String>> graph, String start){
        PriorityQueue<String> ends = graph.get(start);

        if(ends != null){
            while(!ends.isEmpty()){
                String end = ends.poll();
                dfs(result, graph, end);
            }
        }

        result.add(start);
    }
}
