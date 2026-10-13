class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int[] seen = new int[128];

        for (char ch : t.toCharArray()) seen[ch]++;

        int left = 0;

        int count = 0;

        String ans = "";
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (seen[curr] > 0)
                count++;
            seen[curr]--;

            while (count == t.length()) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }

                seen[s.charAt(left)]++;
                if (seen[s.charAt(left)] > 0)
                    count--;
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
