class Solution {
    public boolean isAnagram(String s, String t) {
        int[] seen = new int[26];

        for(char c: s.toCharArray()){
            seen[c - 'a']++;
        }

        for(char c: t.toCharArray()){
            if(seen[c - 'a'] == 0) return false;
            seen[c-'a']--;
        }

               for(int x: seen){
            if(x != 0) return false;

        }

        return true;
    }
}
