/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }


    we have given a graph we need to return a deep copy of the graph.

    we can do at by using a hasmap which will store the old and new node


    then we will travsesrse the old list while mappiing to the new one.


TC - O(n)
SC -  O(n)
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        Map<Node, Node> map = new HashMap<>();

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        Set<Node> seen = new HashSet<>();
        seen.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!seen.contains(neighbor)) {
                    queue.offer(neighbor);
                    seen.add(neighbor);
                }
            }

            map.put(curr, new Node(curr.val));
        }
        seen = new HashSet<>();
                seen.add(node);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!seen.contains(neighbor)) {
                    queue.offer(neighbor);
                    seen.add(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}