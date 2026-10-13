/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 So, we need to add to numbers but here the catch is the numbers are in the form of linkedlist and
 each number is one node

 so simple addition woiuld be easy make a new node or use existing node and add values in both the
 ll and put there. but in case of carry we need to add that as well and if a arry is remaining we
 need to create a new node for it.

 TC - O(n)
 SC - O(1)
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            int rem = sum % 10;

            curr.next = new ListNode(rem);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(rem);
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(rem);
            curr = curr.next;
            l2 = l2.next;
        }

        if(carry != 0){
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
