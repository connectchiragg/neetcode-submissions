class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int diff = first - second;
            if(diff > 0){
                pq.add(diff);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
