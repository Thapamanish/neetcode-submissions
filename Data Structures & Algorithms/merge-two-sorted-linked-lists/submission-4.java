/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 assume first list to be answer and travesrse both list if l1 element is greater simply move ahead
 else pluck l2 node and attach in list 1

 TC - O(n)
 SC- O(1)
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr = list1;
                list1 = list1.next;
            } else {
                ListNode list2Next = list2.next;

                curr.next = list2;
                curr = list2;
                curr.next = list1;
                list2 = list2Next;
            }
        }

        if (list2 != null)
            curr.next = list2;

        return dummy.next;
    }
}