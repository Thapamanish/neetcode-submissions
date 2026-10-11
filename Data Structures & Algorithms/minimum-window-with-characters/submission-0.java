class Solution {
    public String minWindow(String s, String t) {
        int n = t.length();
        int m = s.length();

        if(m < n) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        int required = 0;

        for(char ch: t.toCharArray()){
            if(need[ch] == 0){
                required++;
            }

            need[ch]++;
        }

        int formed = 0;

        int left = 0;
        int start = 0;

        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < m; right++){
            int charToAdd = s.charAt(right);

            window[charToAdd]++;

            if(need[charToAdd] > 0 && window[charToAdd] == need[charToAdd]){
                formed++;
            }

            while(required == formed){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    start = left;
                }

                char charToRemove = s.charAt(left);

                window[charToRemove]--;

                if(need[charToRemove] > 0 && window[charToRemove] < need[charToRemove]){
                    formed--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :  s.substring(start, start + minLen);

    }
}
