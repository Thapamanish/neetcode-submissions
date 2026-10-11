/*
given Array of strings 

encode -> make one string

hello world

think about the space 

#hello#world

but what if # is also in the string
add length

5#hello5#world

this way we can track length till we find # then skip it then the string starts until the length


decode -> make one string to array of string
read until # then add each char till the length and continue


TC -> O(n)

SC -> O(1)



*/
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int idx = 0;

        while(idx < str.length()){
            String count = "";
            while(str.charAt(idx) != '#'){
                count += str.charAt(idx++);
            }
            idx++;
            int wordEnd = idx + Integer.parseInt(count);
            ans.add(str.substring(idx, wordEnd));
            idx = wordEnd;
        }
        return ans;
    }
}
