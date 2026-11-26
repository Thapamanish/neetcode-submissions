class LRUCache {
    private Map<Integer, Node> seen = new HashMap<>();
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);
    private int capacity;
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (seen.containsKey(key)) {
            Node node = seen.get(key);
            rearrangeMRU(node);

            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (seen.containsKey(key)) {
            Node node = seen.get(key);
            node.val = value;
            rearrangeMRU(node);
            return;
        }
                Node node = new Node(key, value);
        seen.put(key, node);
        rearrangeMRU(node);

        if (seen.size() > capacity)
            removeLRU();


    }

    public void rearrangeMRU(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        tail.prev.next = node;
        node.prev = tail.prev;

        node.next = tail;
        tail.prev = node;
    }

    public void removeLRU() {
            seen.remove(head.next.key);
        head.next = head.next.next;
        head.next.prev = head;
    
    }
}
