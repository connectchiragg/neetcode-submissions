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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(tooSmall(head, k)){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;

        for(int i = 0; i < k; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = reverseKGroup(curr, k);
        head.next = curr;

        return prev;
    }

    private boolean tooSmall(ListNode head, int k){
        while(k-- > 0){
            if(head == null) return true;
            head = head.next;
        }

        return false;
    }
}
