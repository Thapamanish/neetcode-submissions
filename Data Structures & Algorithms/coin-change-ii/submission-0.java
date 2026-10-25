/*
so I ahve to find in how many ways I can make the given amount with given coins


I can try to find with the given coins I progressively check can I make till the amount

0 1 2 3 4
0
1 1 1 1 1
2 1 2 2 3
3 1 2 3 4

TC -> O(m * n)


*/

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for(int i = 1; i < coins.length + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1 ; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; 
                }
            }
        }

        return dp[coins.length][amount];
    }
}
