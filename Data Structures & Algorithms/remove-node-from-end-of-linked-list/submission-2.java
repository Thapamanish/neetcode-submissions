/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 given a ll remove node from the end

 e.g

  1 2 3 4

  n = 1

  remove 4

  n = 3

  remove 2


  n is 1 based 


  simple approach we can do is count the length then do - n

  4 - 1 = 3

  then go till 3 then do curr.next = curr.next.next

  but we need to do two passes here, nstead we can use slow an fast pointer appraoch

we need to land before the node we need to remove so we will use a dummypinter before
  start a poiinter and traverse till n then again start another pinterfrom the beginning and travesrse both pointer untill the first pointer.next is not null

  then do slow.next = slow.next.next

  e.g

  1 2 3 4, 2

  dum 1 2 3 4

  fast = 1  2 3 4
  slwo = du 1 2 3

  tC - O(n)
  Sc - O(1)

  1
  dum 1


 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        while(n != 0){
            fast = fast.next;
            n--;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
