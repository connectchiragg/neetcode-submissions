class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((t1, t2) -> t1.get(1).compareTo(t2.get(1)));
        Map<String, List<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), v -> new ArrayList<>()).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>(Collections.nCopies(tickets.size() + 1, null));

        dfs(result, graph, "JFK", tickets.size());
        return result;
    }

    private int dfs(List<String> result, Map<String, List<String>> graph, String start, int i){
        List<String> ends = graph.get(start);

        if(ends != null){
            for(int j = 0; j < ends.size(); j++){
                String end = ends.get(j);
                if(end == null) continue;
                ends.set(j, null);
                i = dfs(result, graph, end, i);
            }
        }
        
        graph.remove(start);
        result.set(i, start);
        return --i;
    }
}
