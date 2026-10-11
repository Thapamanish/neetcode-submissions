/*
question is saying I need to make maximum profit.

given : list of cost where I can buy or sell

to make profit I have to buy at low and sell at high

I can't buy at high and sell at low it is a loss.

I could have multiple profits but I need maximum

two things: buy at low and sell at high

approach 1: take every price and after that try to sell, maintain a maxprofit and return the maxprofit once traversal ends

TC -> O(n^2) because we are trying out every number multiple times

approach 2: keep track of lowest and maintain max profit.

we start at 10, we don't know what is ther ein the futer so we consiter it as lowest, then we traverse and find smaller then exisitng we replace lowest. but if we find a larger value than current we subtract and keep max in maxProft.

TC -> O(n) -> we are traversing only one along n length array
SC -> O(1) -> no extra space

*/

class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int maxProfit = 0;

        for(int price: prices){
            lowest = Math.min(lowest, price);
            maxProfit = Math.max(maxProfit, price - lowest);
        }

        return maxProfit;
    }
}
