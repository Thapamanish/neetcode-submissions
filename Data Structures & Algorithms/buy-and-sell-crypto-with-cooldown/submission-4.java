/*




*/

class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];

        return solve(prices, 0, false, dp);
    }

    private int solve(int[] prices, int day, boolean holding, Integer[][] dp) {
        if (day >= prices.length)
            return 0;

        int state = holding ? 0 : 1;

        if (dp[day][state] != null)
            return dp[day][state];

        int best = solve(prices, day + 1, holding, dp);

        if (holding) {
            int sell = prices[day] + solve(prices, day + 2, false, dp);
            best = Math.max(sell, best);
        } else {
            int buy = -prices[day] + solve(prices, day + 1, true, dp);
            best = Math.max(buy, best);
        }
        dp[day][state] = best;
        return best;
    }
}
