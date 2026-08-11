/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) ->
            Integer.compare(a.val, b.val));

        for(int i = 0; i < n; i++){
            pq.add(lists[i]);
        }

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            
            if(curr.next != null){
                pq.add(curr.next);
            }

            dummy.next = curr;
            dummy = dummy.next;

        }

        return result.next;
    }
}
