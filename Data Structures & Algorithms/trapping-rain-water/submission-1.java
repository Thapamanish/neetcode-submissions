/*
We have array of integer, which is elevation in the map

each value in the height array is height of the bar, so between each bar there could be water stored.we have ot find the total amount of water stored in the whole height array



0 2 0 3 1 0 1 3 2 1


0 -> no water
2 -> I see left and right it is highest so no water is stored
0 -> left 2 and right 3 so water could be stored 2(3) - 1(2) = 1 * min(2, 3) = 2 
3 -> left 0 and right 1 no water
1 -> left 3 and right 0 no water


so I keep 4 pointers 2 left and 2 right

left

left -> to traverse from left to right
leftMax -> find the tallest height so that we can compare it with rightMax

right -> to travers from right to left
rightMax -> find the tallest height on right to compare it with leftMax


as soon as left >= leftMax we switch the leftMax = left but before switching store ans

ans += (3 - 1 - 1) * leftMax

left    = 0 2 0 3 1 0 1 3
leftMax = 0 2 2 3 3 3 3 3


but how should we take care of small bumps we can't assume that whole floor is plan

also how should we take care of edges if we think as soon as we find something bigger it should not allow us to find the arreas there should be some limiting factor

instead of left >= leftMax what if left < leftMax

if found bigger do 


find the first 

0 1 2 3 4 0 5
cvcbvcbvcb

*/


class Solution {
    public int trap(int[] height) {
        int left = 0, leftMax = height[0], right = height.length - 1, rightMax = height[height.length - 1];
        int water = 0;

        while(left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax < rightMax){
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }

        return water;

    }
}
