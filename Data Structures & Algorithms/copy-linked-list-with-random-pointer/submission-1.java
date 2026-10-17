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

here the concept is that we not only work with next we also work with random, with next it is easy
that we create as soon ass we need it but with random it can point to any node

so we first make map of old and new to track the nodes then join the ponters
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            Node newCurr = map.get(curr);
            newCurr.next = map.get(curr.next);
            newCurr.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
