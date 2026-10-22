/*
I can rob but can't rob from two adjacent houses


so if I rob from 0 then I can't rob from 2

so I have to see how to max max loot

1 1 3 3

I loot from 1 then I can loot from 3rd house

i lot from 2 then I can loot from the 4th house


2 9 8 3 6

I loot 1 8 6
I loot 9 3


so even if I pick the highest in the beginning there is chance I couldn't make it max

so greedy won't work here

can I recurese?

with first + 2 and second + 2?

but it is not necessary to loot the +2 house I can loot the +3 house as well

and return the max?


recursion does same task again and again so can we use dp?



*/

class Solution {
    public int rob(int[] nums) {
        // return Math.max(maxLoot(nums, 0), maxLoot(nums, 1));
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        for(int i = 3; i < nums.length; i++){
  
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
 
        }
        int maxVal =0;

        for(int i = 0; i < nums.length; i++){
            maxVal = Math.max(maxVal, dp[i]);
        }

        return maxVal;
    }

    // public int maxLoot(int[] nums, int start){
    //     if(start >= nums.length) return 0;

    //     return nums[start] + Math.max(maxLoot(nums, start + 2), maxLoot(nums, start + 3));
    // }
}
