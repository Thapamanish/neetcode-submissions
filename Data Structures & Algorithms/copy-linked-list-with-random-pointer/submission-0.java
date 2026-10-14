/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
we have to make a deep copy.

it would be very easy to do it if there was only one pointer, because the pointer will be pointing to next node which I will create. but now the pointer could point to any node which could be in past or present so for this I need to do some setup work

I will create a map where I will keep key as old node and value as new node

then when I traversere the old and new list I will assign

for next pointer
newNext = map.get(oldcurr.next)
newRandom = map.get(oldcurr.random)
newCurr.next = newNext
newCurr.random = newRandom


then return head


TC - O(n)
SC - O(n)
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> reference = new HashMap<>();

        Node curr = head;
        while(curr != null){
            reference.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        Node newHead = reference.get(head);
        while(head != null){
            Node newNext = reference.get(head.next);
            Node newRandom = reference.get(head.random);
            Node newCurr = reference.get(head);

            newCurr.next = newNext;
            newCurr.random = newRandom;
            head = head.next;
        }

        return newHead;
    }
}
