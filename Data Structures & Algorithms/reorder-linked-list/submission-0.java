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
    public void reorderList(ListNode head) {
        impl(head, head);
    }

    private ListNode impl(ListNode left, ListNode right){
        if(right == null){
            // end reached
            return left;
        }

        left = impl(left, right.next);
        if(left == null){
            return null;
        }

        if(left == right || left.next == right){
            right.next = null;
            return null;
        }

        ListNode next = left.next;
        left.next = right;
        right.next = next;
        return next;
    }
}
