class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i =0; i < s.length(); i++){
            char bracket = s.charAt(i);

            if(bracket == '{'){
                stack.push('}');
            } else if(bracket == '(' ){
                stack.push(')');
            } else if (bracket == '['){
                stack.push(']');
            } else {
                if(stack.isEmpty()) return false;

                if(stack.pop() != bracket) return false;
            }
        }

        return stack.isEmpty();
    }
}
