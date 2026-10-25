/*
so, I have an array with coins denominaitons

we have to sum up to the target using any coin denomination

similar to the sum up to the target, combination sum


but we have to find the min number to do it

we can do it with the recursion

we keep track of sum and as soon as we find the amount we compare with ans and keep the min
1 2 3
1 1 1 1 1 1
1 1 1 1 1 2
1 1 1 1 1 3
1 1 1 1 2 2
1 1 1 1 2 3
1 1 1 1 3 3
1 1 1 2 2 2
1 1 1 2 2 3
1 1 1 2 3 3
1 1 1 3 3 3

TC -> O(2^n)
SC -> O(h) stack size


what if I make a dp denomination to amount from 1 to amount

we can save the repeatition




*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        // int[] best = new int[1];
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[0][i] = amount + 1;
        }

        dp[0][0] = 0;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
               if(coins[i - 1] > j){
                dp[i][j] = dp[i - 1][j];
               } else {
                dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
               }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[coins.length][amount] > amount ? -1: dp[coins.length][amount];
        // Arrays.fill(best, Integer.MAX_VALUE);
        // solve(coins, 0, amount, best, 0);
        // return best[0] == Integer.MAX_VALUE ? -1 : best[0];
    }

    // private void solve(int[] coins, int start, int amount, int[] best, int count) {
    //     if (amount < 0 || start >= coins.length)
    //         return;
    //     if (amount == 0) {
    //         best[0] = Math.min(best[0], count);
    //         return;
    //     }

    //     for (int i = start; i < coins.length; i++) {
    //         solve(coins, i, amount - coins[i], best, count + 1);
    //     }
    // }
}
