/*
it is pretty straight forward

pop when found operator
and calculate in reverse direction of pop
assume given sequence is valid

TC-> O(n)
SC -> O(n) stack

*/

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a - b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a / b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a * b);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
