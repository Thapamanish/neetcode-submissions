/*
we need to encode the string in such a way that if we should be correctly decode it into the original list of string

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
        List<String> decodedStrings = new ArrayList<>();
        int right = 0;
        int digit = 0;
        while(right < str.length()){
            char currChar = str.charAt(right);

            if(currChar == '#'){
                right++;
                decodedStrings.add(str.substring(right, right + digit));
                right = right + digit;
                digit = 0;
                continue;
            }
            digit = digit * 10 + currChar - '0'; 
            right++;
        }
        return decodedStrings;

    }
}
