/*
we have two string

s and t

we need to find t in s

so it need not to be exact any other character could be there but all the char in t should be in s.
And we need to find the min length as there could be any


S = OUZODYXAZV
t = XYZ

I use sliding window and a hash array

in the hash aray I will put the occurence of t

and as I traverse S

check if the count == size of t if yse update the best start after finding shrink l until the
condition is false;

TC -> O(n)
SC -> O(1)

*/
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int left = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;
        int count = t.length();
        int[] seen = new int[128];

        for (char ch : t.toCharArray()) {
            seen[ch]++;
        }

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (seen[ch] > 0) {
                count--;
            }
            seen[ch]--;

            System.out.println(count);

            while (count == 0) {
                if (bestLen > right - left + 1) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                ;
                seen[s.charAt(left)]++;
                if (seen[s.charAt(left)] > 0)
                    count++;
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}


