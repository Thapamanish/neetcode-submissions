/*
we have to find longest substring without any char being repeated

so need to keep track of characters in a window

we can use a hasharray and increase the window and as soon as the we find any conflict, new left would be left = conflict + 1

also left < curr then skip



*/
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;
        int[] seen = new int[256];


        Arrays.fill(seen, -1);

        int left = 0;
        int bestLen = 1;
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(seen[ch] != -1){
                if(left <= seen[ch]){
                   left = seen[ch] + 1;
                }

            }
             bestLen = Math.max(bestLen, i - left + 1);
             seen[ch] = i;
        }

        return bestLen;
    }
}
