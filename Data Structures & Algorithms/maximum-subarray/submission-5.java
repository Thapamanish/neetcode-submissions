/*
we have an array

and we have to find subarray which give max sum. since it has negative integers so the sum doesn't necessarliy increase as we traverse


so we find prefix sum as we go and keep track of lowest prefix sum and and we proceed we minus current sum with the last lowest prefix sum and keep updating the ans.



*/

class Solution {
    public int maxSubArray(int[] nums) {
        int lastSmallPrefix = 0;
        int prefix = 0;
        int best = Integer.MIN_VALUE;
        for(int num: nums){
            prefix += num;
            best = Math.max(best, prefix - lastSmallPrefix);
            lastSmallPrefix = Math.min(lastSmallPrefix, prefix);
        }

        return best;
    }
}
