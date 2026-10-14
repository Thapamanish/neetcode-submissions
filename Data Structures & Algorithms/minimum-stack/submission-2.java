/*
quick is asking to make a min stack with all operation within O(1)

push pop and peek is easy but we need to do the min number also at constant time.


we can achieve this my creating one extra stack whicch keeps the track of minimum at that point of
element

for e.g

5 4 6 2 4

so the min will look like

5 4 4 2 2

so at 6 the min is 4 but when 2 comes it becomes the min

TC - O(1)
SC - O(n)


*/

class MinStack {
    Deque<Integer> stack, minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(!minStack.isEmpty() ? Math.min(minStack.peek(), val) : val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
