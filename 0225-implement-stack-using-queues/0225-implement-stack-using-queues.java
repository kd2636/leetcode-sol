class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            int e = queue.remove();
            queue.add(e);
        }
        return queue.remove();
    }
    
    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            int e = queue.remove();
            queue.add(e);
        }
        int e = queue.remove();
        queue.add(e);
        return e;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
