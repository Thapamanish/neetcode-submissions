/*
given : array of integers

find: longest consecutive sequence of numbers


2 20 4 10 3 4 5

2 3 4 5
20
10


we can do is sort the array
ans = 1
check from 2nd element as n-1 = n ? if yes then store it in ans we can use a flag to check if
consecutive is broken or not



*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 1;
        boolean flag = true;
        int currentAns = 1;
        for (int i = 1; i < nums.length; i++) {
            if (flag)
                currentAns = 1;
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] == nums[i] - 1) {
                currentAns++;
                flag = false;
                ans = Math.max(ans, currentAns);
            } else {
                flag = true;
            }
        }

        return ans;
    }
}
