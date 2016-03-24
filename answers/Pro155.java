class MinStack {
    Stack<Integer> origin = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        origin.push(x);
        if (min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        int x = origin.pop();
        if (x == min.peek()){
            min.pop();
        }
    }

    public int top() {
        return origin.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
