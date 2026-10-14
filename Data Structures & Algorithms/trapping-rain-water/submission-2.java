/*
we have array of integer and each integer is elevation in the map and we nee d to find how much
water can we trap


so basically here we can solve this using two pointer but we need a max for those two pointer
because we need to calulate the water at the elevation if that pointer is supposed to be moved.

0 2 0 3 1 0 1 3 2 1

left = 0 2
right = 1 2 3
leftMax = 0 2
rightMax = 1 2 3

ans = 0 (left  - Min(leftMax, rightMax))


TC - O(n)
SC - O(1)


*/

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];

        int ans = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);


            if (leftMax < rightMax) {
                ans += Math.min(leftMax, rightMax) - height[left];
                left++;
            } else {
                ans += Math.min(leftMax, rightMax) - height[right];
                right--;
            }
        }

        return ans;
    }
}
