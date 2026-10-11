/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }


  The goal here is to order the ll in reverse so that when travesed and printed it is reverse order

  e.g

  0 1 2 3

  3 2 1 0

  we need to keep track two thing, prev and next

  prev = null;

  whle head is not null
        node next = head.next
        head.next = prev
        prev = head
        head = next
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
