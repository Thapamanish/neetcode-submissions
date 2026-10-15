/*
We need to find the water at current location, for that I need to know what is the max height of the bar on max left and what is the max height of the bar on the right. With that only we will jknow that the water will be contatined

0 2 0 3 1 0 1 3 2 1

left = 0
right = 1
leftMax = 0
rightMax = 1


leftMax = Math.min(heileft, leftMax)
rightMax = Math.min(heighright, rightMax)
if(leftMax < rightMax)
    ans += leftMax - 0 (left) 
else
    ans += rightMax - right


TC - O(n)
SC - O(1)

*/

class Solution {
    public int trap(int[] height) {
        int left = 0, leftMax = height[left];
        int right = height.length - 1, rightMax = height[right];
        int ans = 0;

        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if(leftMax < rightMax){
                ans += leftMax - height[left++];
            } else {
                ans += rightMax - height[right--];
            }
        }

        return ans;
    }
}
