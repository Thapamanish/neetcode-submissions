/*
we can use hasHmap but to do in extra space we should use bit XOR properties;

*/

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int num: nums){
            ans ^= num;
        }

        return ans;
    }
}

/*

*/
