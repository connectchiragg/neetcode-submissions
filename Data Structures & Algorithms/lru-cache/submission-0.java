class LRUCache {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node right;
    private Node left;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.right = new Node(-1, -1); // dummy head
        this.left = this.right;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        // map contains key and so does LRU
        int value = map.get(key).value;
        right.next = new Node(key, value);
        right = right.next;
        map.put(key, right);

        return value;
    }
    
    public void put(int key, int value) {
        right.next = new Node(key, value);
        right = right.next;
        map.put(key, right);

        if(left.key == -1){
            left = left.next;
        }

        while(map.size() > capacity){
            if(map.get(left.key) == left){
                map.remove(left.key);
            }

            left = left.next;
        }
    }
}
