/*
check if the string has same number of chars


hasharray(since only lower case) to add and remove count for s and t

travesre and check if each count is 0 or not, if yes return true else false

TC - O(n)
SC - O(1)


*/


class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0) return false;
        }

        return true;
    }
}
