class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), v -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>(Collections.nCopies(tickets.size() + 1, null));

        dfs(result, graph, "JFK", tickets.size());
        return result;
    }

    private int dfs(List<String> result, Map<String, PriorityQueue<String>> graph, String start, int i){
        PriorityQueue<String> ends = graph.get(start);

        if(ends != null){
            while(!ends.isEmpty()){
                String end = ends.poll();
                i = dfs(result, graph, end, i);
            }
        }
        
        graph.remove(start);
        result.set(i, start);
        return --i;
    }
}
