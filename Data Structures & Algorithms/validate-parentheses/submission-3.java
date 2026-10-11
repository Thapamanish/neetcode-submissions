/*
[({})]

valid
1. if bracket is opened it should be closed
2. closed in the right order
3. bracket should be close by it's own kind

[()
[(])


{[()]}

LIFO - stack

stack

( , [, {

then I will push it

( = ), { = }, [= ] -> map

value == currInput

return invalid if not same


TC - O(n) for traversing
SC - O(n) for the stack

*/

class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> brackets = Map.of(')','(','}','{', ']','[');

        Deque<Character> stack = new ArrayDeque<>();

        for(Character ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                if(brackets.get(ch) != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
        
    }
}
