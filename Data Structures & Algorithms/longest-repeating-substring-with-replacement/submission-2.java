/*
given: a string s and a value k. I can use the value to replace any k char in the string to get
longest repeating character.

e.g

XYYX , 2

I can replace YY to XX then I will have 4 consecutive repeating characters.


AAABABB, 1

How to replace in such a way I have maximum consecutive chars. so I have to count it

AAABABB
AAAAA

k = 0

A: 2
B: 3


left = 0;
right = 0;

map = {A: 1}

traverse s

currlen = right - left + 1
d

if currlen - maxfreq <= k ans = Math.max(ans, diff)

else
    whle(currlen - maxfreq <= k){
        map.rmove(left occurence)
        find maxfreq
    }


return ans;



*/
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            int maxFreq = 0;
            for (int i = 0; i < 26; i++) {
                maxFreq = Math.max(maxFreq, freq[i]);
            }

            int currLen = right - left + 1;

            int diff = currLen - maxFreq;

            if (diff <= k)
                ans = Math.max(ans, currLen);
            else {
                while (diff > k) {
                    freq[s.charAt(left) - 'A']--;
                    left++;
                    for (int i = 0; i < 26; i++) {
                        maxFreq = Math.max(maxFreq, freq[i]);
                    }
                    currLen = right - left + 1;
                    diff = currLen - maxFreq;
                }
            }
        }

        return ans;
    }
}
