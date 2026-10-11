/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

we have a list and we have to reorder it in below way

0 n-1 1 n-2 2 n-3 ....

so basically take first then take last take second then take second last

for that I have to travese from first and last at once

So, for that I will find the mid first using slow and first pointer

then I will reverse the list from mid to last then traverse at once and merge

TC - O(n + n / 2)
SC - O(1)
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode prev = null;

        while(secondHead != null){
            ListNode next = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = next;
        }

        secondHead = prev;

        ListNode firstHead = head;
        while(secondHead != null){
            ListNode secondNext = secondHead.next;
            ListNode firstNext = firstHead.next;
            firstHead.next = secondHead;
            secondHead.next = firstNext;
            secondHead = secondNext;
            firstHead = firstNext; 
        }
    }
}
