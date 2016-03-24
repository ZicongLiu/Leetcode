class MyQueue {
    Stack<Integer> stk1 = new Stack<Integer>();
    Stack<Integer> stk2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stk1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stk2.isEmpty()){
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
        }
        stk2.pop();
    }

    // Get the front element.
    public int peek() {
        
        if (stk2.isEmpty()){
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
        }
        return stk2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stk1.isEmpty() && stk2.isEmpty());
    }
}