/*
we need track if the brackets are opening and closing in the right order
there is no extra opening or closing brackets.


will use stack to track the lst opening brackets

TC - O(n)
SC - O(n)


*/

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char lastSeen = stack.pop();

                if (ch == '}' && lastSeen != '{')
                    return false;
                 if (ch == ')' && lastSeen != '(')
                    return false;
                 if (ch == ']' && lastSeen != '[')
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
