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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        int count = 0;

        ListNode curr= head;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        int nodeToDelete = count - n + 1;

        ListNode prev = curr;


        curr = head;
        count = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        prev = dummy;

        while(count < nodeToDelete){
            prev = curr;
            curr = curr.next;
            count++;
        }

        System.out.println(count);

        prev.next = curr.next;

        return dummy.next;
    }
}
