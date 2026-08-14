class KthLargest {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    Map<Integer, Integer> minMap;
    Map<Integer, Integer> maxMap;
    int k;
    int minSize = 0;
    int maxSize = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        min = new PriorityQueue<>();
        max = new PriorityQueue<>();
        minMap = new HashMap<>();
        maxMap = new HashMap<>();
        minSize = 0;

        for(int i : nums){
            minMap.put(i, minMap.getOrDefault(i, 0) + 1);
            min.add(i);

            if(min.size() > k){
                int top = min.peek();
                minMap.put(top, minMap.get(top) - 1);
                maxMap.put(top, maxMap.getOrDefault(top, 0) + 1);
                max.add(min.poll());
            }
        }

        minSize = min.size();
        maxSize = max.size();
    }

    public int add(int val) {
        minMap.put(val, minMap.getOrDefault(val, 0) + 1);
        min.add(val);
        minSize++;
        
        if(minSize > this.k){
            while(!min.isEmpty() && minMap.get(min.peek()) == 0){
                min.poll();
            }

            int top = min.peek();
            minMap.put(top, minMap.get(top) - 1);
            minSize--;
            maxMap.put(top, maxMap.getOrDefault(top, 0) + 1);
            maxSize++;
            max.add(min.poll());
        }

        return min.peek();
    }

    public int remove(int val){
        if(maxMap.get(val) > 0){
            maxMap.put(val, maxMap.getOrDefault(val, 0) - 1);
            maxSize--;
            return min.peek();
        } else if(minMap.get(val) > 0){
            minMap.put(val, minMap.get(val) - 1);
            minSize--;

            if(maxSize > 0){
                while(!max.isEmpty() && maxMap.get(max.peek()) == 0){
                    max.poll();
                }

                int top = max.peek();
                maxMap.put(top, maxMap.get(top) - 1);
                maxSize--;
                minMap.put(top, minMap.getOrDefault(top, 0) + 1);
                minSize++;
                min.add(max.poll());
            }
        }

        return min.peek();
    }
}
