/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

Given: two sorted list and we have to return final list where everything is sorted. basically merge
the list and final list should also be sorted


I can use two pointer one at each list and compare and make a new list while copying the values from
the current node

for e.g
    p
1 2 4

  q
1 3 5



1 1 2


but here we are copying the value to new node not using the existing node. I think we can jus
rearrange exxisint node

I will chose one list as final ans, and add a dummy pointer to the first so that I have track of
first node


d 1 2 4

1 3 5


then I keep p and 1 in the list then

if p.val < q.val then good no need to do anything as our final list is good
just do p -> p.next

if p.val > q.val

prev.next = q

temp = q.next;
q.next = p
q = temp


then we see if q is not null then it means there are elements still remaingin in q then prev.next =
q


return dummy.next



 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode prev = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                ListNode next = list2.next;
                list2.next = list1;
                list2 = next;
                prev = prev.next;
            }
        }

        if (list2 != null)
            prev.next = list2;

         return dummy.next;
    }

}