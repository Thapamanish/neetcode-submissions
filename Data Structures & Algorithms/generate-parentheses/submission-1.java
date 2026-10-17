/*
when brackets open then only we can close so 
open < close then only you are allowed to close

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;

        List<String> ans = new ArrayList<>();

        findPairs(ans, open, close, new StringBuilder());

        return ans;
    }

    private void findPairs(List<String> ans, int open, int close, StringBuilder sb){
        if(open == 0 && close == 0){
            ans.add(sb.toString());
        }

        if(open > 0){
            sb.append('(');
            findPairs(ans, open - 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close > open){
            sb.append(')');
            findPairs(ans, open, close - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
