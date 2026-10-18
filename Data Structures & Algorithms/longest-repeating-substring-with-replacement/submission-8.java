/*
we get only uppercase

and find the longest repeating sequence

AAAAA -> 5

we are also given k with which I can replace and contribute to the longest length

as we traverse it would be very difficult to think in way like which element we can make like we do
visually like in XYYX

we can say either replace X or Y

but while in code we can keep track of the max char in the sequence and as soon as we find curr
lenght - max < k we store it in ans and if not decrease the window

TC -> O(n)
SC -> O(1) we will use hasharray of O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] seen = new int[128];
        int left = 0;
        int best = 0;
        int currMax = 0;
        for (int right = 0; right < s.length(); right++) {
            seen[s.charAt(right)]++;
            currMax = Math.max(currMax, seen[s.charAt(right)]);
            while (right - left + 1 - currMax > k) {
                seen[s.charAt(left)]--;
                left++;
            }
            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}
