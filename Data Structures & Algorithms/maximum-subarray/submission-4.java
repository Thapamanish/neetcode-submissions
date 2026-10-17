/*
we have an array of integer

we have to find a sum which is largest by taking the contigious non empty sequence

2 -3 4 -2 2 1 -4 4

2 -> 2

2 -3 -> -1
2 -3 4 -> 3

4 -> 4

4 -2 2 -> 2

4 -2 2 1 -1 4 -> 8 (ans)

2  -> 2
2 -3 -> -1
2 -3 4 -> 3
-2 -3 4 -2 -> -3 

so as soon as the sum becomes -1 we shrink until becomes positive?
2 -> 2
2 -3 -> -1
-3 ->  -3
-3 4 -> 1
-3 4 -2 -> -1
4 -2 -> 2
4 -2 2 -> 4



we have to return the sum
can't sort because we need the sequence
sliding window we can increase the window to take all elements 

with sliding window what is the shrinking condition?

if there is only positive value we can keep on increasing the sum will increase but if negative value decreases the value


2 -1 3 1 3 4 3 7


prefix

I know we have to use prefix

should I check from 0 to curr -1 by subtracting aand find the max;



*/

class Solution {
    public int maxSubArray(int[] nums) {
        int prefix = nums[0];
        int lastSmallest = nums[0];
        int ans = nums[0];

        for(int num: nums){
            prefix += num;
            ans = Math.max(ans, prefix - lastSmallest);
            lastSmallest = Math.min(prefix, lastSmallest);
        }

        return ans;
    }
}
