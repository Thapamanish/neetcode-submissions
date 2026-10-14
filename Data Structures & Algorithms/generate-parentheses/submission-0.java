/*
given n pair of parenthesis , need to find all possible parenthesis with n pair

for e.g

n = 1

()

n = 2

()()
(())

n = 3

((()))
(())()
()(())
()()()
(()())

looks like we need to try with every possible combination, looks like we nee backtracking


if I open

(

then I have to close it

so basically (()
 1 to 3

 open
close
 remove close call again ( i+ 1)
 close


*/
class Solution {
    List<String> ans = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    public List<String> generateParenthesis(int n) {
        recur(n, n, n * 2);
        return ans;
    }

    public void recur(int n, int close, int o) {
        if(n > 0){
            sb.append('(');
            recur(n - 1, close, o);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close > 0 && close > n){
             sb.append(')');
            recur(n, close - 1, o);
            sb.deleteCharAt(sb.length() - 1);

        }
        if(sb.length() == o)
            ans.add(sb.toString());
        
    }
}
