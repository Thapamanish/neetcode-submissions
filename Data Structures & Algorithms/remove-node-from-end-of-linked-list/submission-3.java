/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 remove n from the end  for e.g

 if n = 2

 it means remove the second last node

so if length is 5

5 - 2 = 3 

if we are on the 3 node we can remove it

so we can find length then find difference then travers again

but for this we will need two traversal. we can do it with one travesral as well

using slow and fast pointer.

headstart fast with n and then start slow. this will ensure that when fast is at end slow will be at l - n, start with dummy to land before the node to work with pointer and only one node

TC - O(n)
SC - O(1)
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();

        dummy.next = head;

        ListNode slow = dummy, fast = dummy;

        while(n>0){
            fast = fast.next;
            n--;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
