class LRUCache {
    static class Node {
        int key;
        int value;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
        Node prev;
        Node next;
    }

    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            insertAtLast(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) { 
            node.value = value;
            remove(node);
            insertAtLast(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(head.next.key);
                remove(head.next);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtLast(newNode);
        }
        //System.out.println(map);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtLast(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */