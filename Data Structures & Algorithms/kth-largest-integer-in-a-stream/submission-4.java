class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();

        for(int i : nums){
            pq.add(i);

            if(pq.size() > k){
                pq.poll();
            }
        }

        this.k = k;
    }
    
    public int add(int val) {
        pq.add(val);
        
        if(pq.size() > this.k){
            pq.poll();
        }

        return pq.peek();
    }
}
