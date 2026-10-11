class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i =0; i < s.length(); i++){
            char bracket = s.charAt(i);

            if(bracket == '{' || bracket == '(' || bracket == '['){
                stack.push(bracket);
            } else {
                if(stack.isEmpty()) return false;

                char top = stack.pop();


                if(bracket == '}' && top == '{') continue;
                else if(bracket ==')' && top == '(') continue;
                else if(bracket == ']' && top == '[') continue;
                else return false;
            }
        }

        return stack.isEmpty();
    }
}
