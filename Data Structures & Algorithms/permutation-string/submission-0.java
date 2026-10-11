class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] targetCount = new int[26];
        int[] windowCount = new int[26];

        for(int i = 0; i < n; i++){
            targetCount[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        if(matches(targetCount, windowCount)){
            return true;
        }

        for(int right = n; right < m; right++){
            char charToAdd = s2.charAt(right);
            char charToRemove = s2.charAt(right - n);

            windowCount[charToAdd - 'a']++;
            windowCount[charToRemove - 'a']--;

            if(matches(targetCount, windowCount)) return true;

        }

        return false;
    }

    public boolean matches(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}
