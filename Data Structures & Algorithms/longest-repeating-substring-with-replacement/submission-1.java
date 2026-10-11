class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;

        int maxFreq = 0;
        int best = 0;
        int[] count = new int[26];

        while(r < s.length()){
            int ch = s.charAt(r) - 'A';
            count[ch] += 1;
            maxFreq = Math.max(maxFreq, count[ch] );

    

            while(r - l + 1 - maxFreq > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            best = Math.max(best, r - l + 1);
            r++;
        }

        return best;
    }
}
