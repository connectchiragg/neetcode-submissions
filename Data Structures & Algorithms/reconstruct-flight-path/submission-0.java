class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), v -> new PriorityQueue<>(
                (s1, s2) -> s1.compareTo(s2)
            )).add(ticket.get(1));
            graph.computeIfAbsent(ticket.get(1), v -> new PriorityQueue<>(
                (s1, s2) -> s1.compareTo(s2)
            ));
        }

        dfs(result, graph, "JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(List<String> result, Map<String, PriorityQueue<String>> graph, String start){
        PriorityQueue<String> ends = graph.get(start);

        while(!ends.isEmpty()){
            String end = ends.poll();
            dfs(result, graph, end);
        }

        result.add(start);
    }
}
