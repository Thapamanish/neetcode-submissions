/*
input : array of String
reverse polish notation is
ab+
a + b
ab -
a - b

integer divsion


approach
stack
push to stack as I traverse in the array
if operator found pop twice and secnod pop operator first pop
then push the result
at the end return the last element in the stack

assuming that the  array has valid polish notation

*/
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String str : tokens) {
            if (str.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a + b);
            } else if (str.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a - b);
            } else if (str.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a * b);
            } else if (str.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}
