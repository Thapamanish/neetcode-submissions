/*
we need to track whichever we are opening at last we are closing it first, LIFO behaviour

also if we havenot opened we shouldnot close it

TC -> O(n)
SC -> O(n) stack track last open
*/

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty() || stack.pop() != ch)
                    return false;
            } else {
                if (ch == '{')
                    stack.push('}');
                else if (ch == '(')
                    stack.push(')');
                else
                    stack.push(']');
            }
        }

        return stack.isEmpty();
    }
}
