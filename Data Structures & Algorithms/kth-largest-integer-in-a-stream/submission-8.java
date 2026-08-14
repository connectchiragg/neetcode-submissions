public class NotEnoughElementsException extends RuntimeException {
    public NotEnoughElementsException() {
        super("Fewer than k elements");
    }
}

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Value not found");
    }
}

class Heap {
    PriorityQueue<Integer> heap;
    Map<Integer, Integer> map;
    int size = 0;

    public Heap(boolean min) {
        heap = min ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder());
        map = new HashMap<>();
        size = 0;
    }

    public void prune(){
        while(!heap.isEmpty() && map.get(heap.peek()) == 0){
            heap.poll();
        }
    }

    public void transfer(Heap that){
        prune();
        int top = this.heap.peek();
        this.map.put(top, this.map.get(top) - 1);
        this.size--;
        that.map.put(top, that.map.getOrDefault(top, 0) + 1);
        that.size++;
        that.heap.add(this.heap.poll());
    }

    public void add(int val){
        map.put(val, map.getOrDefault(val, 0) + 1);
        heap.add(val);
        size++;
    }

    public void softDelete(int val){
        map.put(val, map.getOrDefault(val, 0) - 1);
        size--;
    }
}

class KthLargest {
    Heap min;
    Heap max;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        min = new Heap(true);
        max = new Heap(false);

        for(int i : nums){
            min.add(i);
            if(min.size > k){
                min.transfer(max);
            }
        }
    }

    public int add(int val) {
        min.add(val);
        
        if(min.size > this.k){
            min.transfer(max);
        }

        min.prune();
        if(min.size < k){
            throw new NotEnoughElementsException();
        }
        return min.heap.peek();
    }

    public int remove(int val){
        if(max.map.getOrDefault(val, 0) > 0){
            max.softDelete(val);
        } else if(min.map.getOrDefault(val, 0) > 0){
            min.softDelete(val);
            if(max.size > 0){
                max.transfer(min);
            }
        } else {
            throw new NotFoundException();
        }

        min.prune();
        if(min.size < k){
            throw new NotEnoughElementsException();
        }
        return min.heap.peek();
    }
}
