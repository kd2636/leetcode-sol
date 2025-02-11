class Node {
    int key;
    int val;
    int freq;
    Node next;
    Node prev;

    Node() {
    }

    Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DLL {
    // tail -> node1 -> node2 -> head
    Node head;
    Node tail;
    private int size;

    DLL() {
        Node node1 = new Node(-1, -1, -1);
        Node node2 = new Node(-1, -1, -1);
        tail = node1;
        node1.prev = tail;
        node1.next = node2;
        node2.prev = node1;
        head = node2;
        node2.next = head;
        size = 0;
    }

    void insertAtHead(Node node) {
        size++;
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    int size() {
        return size;
    }

}



class LFUCache {

    Map<Integer, Node> keyNodeMap;
    Map<Integer, DLL> freqListMap;
    int minFreq;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        keyNodeMap = new HashMap<>();
        freqListMap = new HashMap<>();
        minFreq = 0;
        size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            processKeyUse(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.val = value;
            processKeyUse(node);
        } else {
            Node node = new Node(key, value, 1);
            if (size == capacity) {
                // removal
                DLL listForRemoval = freqListMap.get(minFreq);
                Node nodeToDelete = listForRemoval.tail.next;
                keyNodeMap.remove(nodeToDelete.key);
                listForRemoval.remove(nodeToDelete);

                // insertion
                insertInCache(node);
            } else {
                insertInCache(node);
                size++;
            }
            minFreq = 1;
        }
    }


    private void processKeyUse(Node node) {
        DLL list = freqListMap.get(node.freq);
        list.remove(node);
        if (minFreq == node.freq && list.size() == 0) {
            minFreq++;
        }
        node.freq = node.freq + 1;
        DLL newList = freqListMap.getOrDefault(node.freq, new DLL());
        freqListMap.put(node.freq, newList);
        newList.insertAtHead(node);
    }

    private void insertInCache(Node node) {
        DLL list = freqListMap.getOrDefault(node.freq, new DLL());
        freqListMap.put(node.freq, list);
        list.insertAtHead(node);
        keyNodeMap.put(node.key, node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */