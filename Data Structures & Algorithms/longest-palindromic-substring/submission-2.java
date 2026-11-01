/*
start from the point and span out left and right keep the best left and best right  at the end
return the substring

TC - O(n)
SC - O(1)

need to take care of odd and even

even it is easy for od?


*/

class Solution {
    public String longestPalindrome(String s) {
        int bestLeft = 0;
        int bestRight = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            left--;
            right++;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                if (bestRight - bestLeft< right - left) {
                    bestLeft = left;
                    bestRight = right;
                }
                left--;
                right++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            right++;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                if (bestRight - bestLeft< right - left) {
                    bestLeft = left;
                    bestRight = right;
                }
                left--;
                right++;
            }
        }

        return s.substring(bestLeft, bestRight + 1);
    }
}
