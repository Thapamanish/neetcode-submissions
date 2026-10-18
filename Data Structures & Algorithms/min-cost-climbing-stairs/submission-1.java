/*
we have given an array of cost

each index is cost of climbing to another step. I can go to i + 1 or i + 2 step

we can do this with recursion

we have to reach cost.length = n step

so two possible way of reaching there is
either n - 1
or
n - 2

choose which ever is charging less

go till n = 0

dp find the optimised way of reaching that step


*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // return Math.min(minCost(cost, cost.length - 1), minCost(cost, cost.length - 2));
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // private int minCost(int[] cost, int n) {
    //     if (n == 0) {
    //         return cost[0];
    //     }

    //     if (n == 1) {
    //         return cost[1];
    //     }
    //     return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    // }
}
