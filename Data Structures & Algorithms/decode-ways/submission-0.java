class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] ways = new int[n + 1];

        ways[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                ways[i] += ways[i + 1];
            }
            if (i + 1 < n) {
                int pair = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');

                if (pair >= 10 && pair <= 26)
                    ways[i] += ways[i + 2];
            }
        }

        return ways[0];
    }
}
