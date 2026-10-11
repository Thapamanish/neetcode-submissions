class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
       int start = 0; 
       int best = 0;

       for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i);

            if(lastSeen[ch] >= start){
                start = lastSeen[ch] + 1;
            }

            lastSeen[ch] = i;

            best = Math.max(best, i - start + 1);

       }

       return best;

    }
}
