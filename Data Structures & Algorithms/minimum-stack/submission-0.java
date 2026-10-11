class MinStack {
    private Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
            return;
        }

        int minVal = getMin();

        if(val <= minVal) stack.push(new int[]{val, val});
        else stack.push(new int[]{val, minVal});
    }
    
    public void pop() {
        if(!stack.isEmpty()) stack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty()) return stack.peek()[0];

        return -1;
    }
    
    public int getMin() {
        if(!stack.isEmpty()) return stack.peek()[1];

        return -1;
    }
}
