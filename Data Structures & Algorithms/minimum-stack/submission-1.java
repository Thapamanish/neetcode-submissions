/*
given:

operations like push, pop, top and get min

challenge is to get all in O(1)

we can implent usnig stack to do push pop and top with O(1)

for min we need to track min all the time 

1 2 0

min 1 1 0

so I will create one more stack where I will store the min for each element and as I pop I will also pop from there.

tC - > O(1)

SC -> O(n) + O(n) -> element stack and min stack




*/


class MinStack {
Deque<Integer> stack, minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
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
