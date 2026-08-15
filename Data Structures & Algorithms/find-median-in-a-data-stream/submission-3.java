class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int size;

    public MedianFinder() {
        size = 0;
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        size++;
        if(min.isEmpty() || num >= min.peek()){
            min.add(num);
            if(min.size() > max.size() + 1){
                max.add(min.poll());
            }
        } else {
            max.add(num);
            if(max.size() > min.size()){
                min.add(max.poll());
            }
        }
    }

    public double findMedian() {
        return size % 2 == 0 ? ((long) min.peek() + max.peek()) / 2.0 : min.peek();
    }
}