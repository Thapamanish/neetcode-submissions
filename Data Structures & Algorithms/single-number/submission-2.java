/*
1. make an array from 0 to  n + 1 , traverse and populate it. again traverse the nums and which ever is not equal to 2 return that index

*/

class Solution {
    public int singleNumber(int[] nums) {
        int value = 0;
        for(int num: nums){
           value ^= num;
        }

        return value;
    }
}
