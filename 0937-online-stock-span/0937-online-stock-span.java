class StockSpanner {

    Stack<Integer> stack;
    List<Integer> prices;

    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);

        while(!stack.isEmpty() && prices.get(stack.peek()) <= price) {
            stack.pop();
        }

        int pge = stack.isEmpty() ? -1 : stack.peek();

        stack.push(prices.size() - 1);

        return prices.size() - 1 - pge;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */