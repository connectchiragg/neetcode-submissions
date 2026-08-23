class Solution {
    record Element(int node, int price, int level){}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>(
            (e1, e2) -> Integer.compare(e1.price(), e2.price())
        );

        Map<Integer, Integer> map = new HashMap<>();

        List<Element>[] graph = new List[n];

        for(int[] flight : flights){
            if(graph[flight[0]] == null){
                graph[flight[0]] = new ArrayList<>();
            }
            graph[flight[0]].add(new Element(flight[1], flight[2], 0));
        }

        pq.add(new Element(src, 0, 0));

        while(!pq.isEmpty()){
            Element curr = pq.poll();

            if(curr.node() == dst) return curr.price();
            if(curr.level() > k) continue;

            Integer minLevel = map.get(curr.node());
            if(minLevel != null && minLevel <= curr.level()) continue;
            if(graph[curr.node()] == null) continue;

            for(Element e : graph[curr.node()]){
                pq.add(new Element(e.node(), curr.price() + e.price(), curr.level() + 1));
            }

            map.put(curr.node(), curr.level());
        }

        return -1;
    }
}
