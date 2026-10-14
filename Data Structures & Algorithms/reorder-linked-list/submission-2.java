/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 find the middle
 reverse it 
 then merge it
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        // find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list2 = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(list2 != null){
            ListNode next = list2.next;
            list2.next = prev;
            prev = list2;
            list2 = next;
        }

        while(prev != null){
            ListNode firstNext = head.next;
            ListNode secondNext = prev.next;
            head.next = prev;
            prev.next = firstNext;
            head = firstNext;
            prev = secondNext;
        }
    }
}
