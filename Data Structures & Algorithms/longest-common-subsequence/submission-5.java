/*
we have two strings

text1 and text2

and we have to find longest common subsequence

one text should be inside another

and any chars can be in between

we have to find the longest

if I delete or not it should be exactly like other

cat


c raaaabt


batm

baaat


the answer should be 3?

since we care about the order

we need to traverse together

we start together

c a t

c r a b t

then we move ahead by counting

0
0

ans =1


1
2

ans = 2

2
4

ans = 3


we only need to find the count

TC - O(max(m, n))
SC - O(1)

which pointer to move and when

if both same then good increase both

should I have to make anchor somehting?

if

*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] bestTill = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) Arrays.fill(bestTill[i], -1);
        return check(text1, text2, 0, 0, bestTill);
    }

    private int check(String text1, String text2, int p1, int p2, int[][] bestTill) {
        if (p1 >= text1.length() || p2 >= text2.length()) {
            return 0;
        }

        if (bestTill[p1][p2] != -1) {
            return bestTill[p1][p2];
        }

        if (text1.charAt(p1) == text2.charAt(p2)) {
            bestTill[p1][p2] = 1 + check(text1, text2, p1 + 1, p2 + 1, bestTill);
            return bestTill[p1][p2];
        } else {
            bestTill[p1][p2] = Math.max(check(text1, text2, p1 + 1, p2, bestTill),
                check(text1, text2, p1, p2 + 1, bestTill));
        }

        return bestTill[p1][p2];
    }
}
