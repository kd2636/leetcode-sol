class LRUCache {

    // head -> node -> node -> node <- tail
    private static class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            insertAtTail(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            insertAtTail(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() != capacity) {
                map.put(key, node);
                insertAtTail(node);
            } else {
                map.remove(head.key);
                removeNode(head);

                map.put(key, node);
                insertAtTail(node);
            }
        }
    }

    private void removeNode(Node node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
            return;
        }

        if (node == head) {
            node.next.prev = head;
            head = node.next;
            return ;
        }

        if (node == tail) {
            node.prev.next = tail;
            tail = node.prev;
            return ;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtTail(Node node) {
        if (tail == null) {
            head = node;
            tail = node;
            node.next = tail;
            node.prev = head;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        node.next = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */