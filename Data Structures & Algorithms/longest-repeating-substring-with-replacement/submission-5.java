/*

we are given a string and a integer.

goal is to return longest same char sequence, we can use replace any k integer to make it longer


so here it is asking only the longest value not which element. so we can track these using a hashmap
and as we see new char we check if it is the max than current max if yes then replace, then diff the
max with the current length until the diff is till k by shrinking the window. and while doing all
this just keep the mas ans.


map : {}

left = 0
maxValue = 0
ans = 0

for right 0 to n

    store in map
    maxValue = max(maxValue, map.get + 1)

    diff = right - left + 1 - maxValue

    if diff > k
        while right -left + 1 - maxvalue <= diff
            map remove left occ
            left++
    ans = max(ans, right - left + 1)


return ans

TC -> O(n)

SC -> O(26) will use hasharray as only capital letter is there


*/

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0, ans = 0, maxFreq = 0;

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
            }

            ans = Math.max(ans, right -left + 1);
        }

        return ans;
    }
}
