/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 WE need to find if there is cycle in a linkedlist, cycle means if we visit the already visited node then it has cycle


 simple approach wiould be use hashset and check everytime you traverse and if cycle the node will be already in hashset


 there is another approach of slow and fast pointer where we use slow and fast pointer. we run slow once and fast twice and ift ehre is a cycle they land at one node as we go ahead.

 TC - O(N)
 SC - O(1)
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;

           if(slow == fast) return true;
        }

        return false;
    }
}
