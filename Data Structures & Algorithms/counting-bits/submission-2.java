/*
we know how to count the bits for a number

n &= (n - 1)
count++;

but we have to find the range

so there is some repeative work like

if we find for 1

then we don't need to calculate for it again

while finding for ahead





*/

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        for (int i = 0; i <= n; i++) {
            int num = i;
            int count = 0;

            while (num != 0) {
                num &= (num - 1);
                count++;

                // if (dp[n] != -1) {
                //     dp[i] = count + dp[n];
                //     break;
                // }
            }
            dp[i]= count;
        }

        return dp;
    }
}
