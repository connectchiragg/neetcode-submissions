class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node right;
    private Node left;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.left = new Node(-1, -1); // dummy head
        this.right = new Node(-1, -1); // dummy tail
        left.next = right;
        right.prev = left;
    }

    private void remove(Node curr){
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    private void add(Node node){
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;

        // map contains key and so does LRU
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            // map contains key and so does LRU
            node = map.get(key);
            remove(node);
            node.value = value;
        }
        else {
            node = new Node(key, value);
        }

        add(node);
        map.put(key, node);

        if(map.size() > capacity){
            Node stale = left.next;
            remove(stale);
            map.remove(stale.key);
        }
    }
}
