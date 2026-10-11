/*
if given parentheses are valid or not

valid examples
([{}])

invalid examples are
(([))
[{}}]
[(])
)([])


a pattern can be seen here. last opened parenthesis should be closed first
-> LIFO -> stack

map(}:{, ]:[, ):()
stack = empty


TC - O(n)
SC - O(n)

*/


class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> brackets = Map.of('}', '{', ')','(',']','[');

        for(char ch: s.toCharArray()){
            if(brackets.containsKey(ch)){
                if(stack.isEmpty())
                    return false;
                if(brackets.get(ch) != stack.pop()) return false;
            }else
                stack.push(ch);


        }

        return stack.isEmpty();
    }
}
// very dissapointed in this, logic came implemented, but lots of bug I am not thinking through the solution, missed a lot of edge casesa, had to take the help 