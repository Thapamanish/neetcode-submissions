/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 0 1 2 3 

 3 2 1 0


 with LL there are pointers 
if have to reverse I need to remember next and previous so that I can assign curr prev as next and also keep track of current next


0->1->2->3

0<-1 2->3

prev = 0
curr = 1
curr.next = 0

next = curr.next
curr.next = prev
prev = curr
curr = next

 will it work for the first and last node?

TC -> O(n)
SC -> O(1)

 */

class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null) return head;

        ListNode curr = head, prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
        
    }
}
