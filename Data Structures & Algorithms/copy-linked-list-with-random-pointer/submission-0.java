/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copy = new Node(0);
        Node itr1 = head;
        Node itr2 = copy;
        int len = 0;
        int i = 0;

        while(itr1 != null){
            len++;
            itr1 = itr1.next;
        }

        Map<Node, Node> map = new HashMap<>();

        itr1 = head;

        while(itr1 != null){
            itr2.next = new Node(itr1.val);
            // itr2 is one step behind because we started with dummy
            itr2 = itr2.next;
            map.put(itr1, itr2);
            itr1 = itr1.next;
        }

        copy = copy.next;

        itr1 = head;
        itr2 = copy;

        while(itr1 != null){
            itr2.random = map.get(itr1.random);
            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        return copy;
    }
}
