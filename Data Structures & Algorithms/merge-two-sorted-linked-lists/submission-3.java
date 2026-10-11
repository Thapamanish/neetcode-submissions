/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 given: two sorted ll
 o/p : one sorted ll


 since both are sorted we need to merge it efficiently 

 make one list as ans and pint a dummy node at it so that even if we need to pull first node from another list we have pointer to it

 then keep two pointer at each list to track

 and one prev pinter to in first list to track last node for final sorted list

 at last if list 2 is not empty add to to the final list

 return next of dummy pointer

 TC -> O(n) traversal
 SC - > O(1)
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = list1;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                prev = list1;
                list1 = list1.next;
            } else {
                ListNode next = list2.next;
                prev.next = list2;
                prev = list2;
                prev.next = list1;
                list2 = next;
            }
        }

        if(list2 != null) prev.next = list2;

        return dummy.next;
    }
}