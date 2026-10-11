/*
given a string

o/p : find a longest substring without repeating chars


zxyzxyz

o/p -> zxy or xyz or yzx


we can do it using sliding window technique
1. track where the unique sequence is starting and second is when it is ending
2. keep a map to track if new char is already in the sequence if not then add it to the answer but
if yes then we have to shrink it


zxyzxyz

abba


{z: 0, x: 1, y: 2}

ans = 3

left = 0 -> max(left, map.get(char) + 1)
right = 2


tC - O(n)
SC - O(n)


*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }
            longest = Math.max(longest, right - left + 1);
            lastSeen.put(ch, right);
        }

        return longest;
    }
}
