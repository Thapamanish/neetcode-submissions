/*

so we can't loot adjacent

so at each point I have a choice whether I have to loot from curr + prev's prev or skip current and
take prev

since it is circular I can't loot first and last as it is circular

so I need to find how much I can loot if I start from first till seconlast

and from second to last

TC - > O(n + n)
SC -> O(1)

*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int onePrev = 0;
        int twoPrev = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int currLoot = Math.max(nums[i] + twoPrev, onePrev);
            twoPrev = onePrev;
            onePrev = currLoot;
        }

        int onePrevAgain = 0;
        int twoPrevAgain = 0;

        for (int i = 1; i < nums.length; i++) {
            int currLoot = Math.max(nums[i] + twoPrevAgain, onePrevAgain);
            twoPrevAgain = onePrevAgain;
            onePrevAgain = currLoot;
        }

        return Math.max(onePrev, onePrevAgain);
    }
}
