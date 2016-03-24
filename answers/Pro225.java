class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue2.offer(x);
        
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue1.poll();
    }

    // Get the top element.
    public int top() {
        return queue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return (queue1.isEmpty() && queue2.isEmpty());
    }
}