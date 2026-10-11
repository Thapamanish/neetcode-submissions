/*

given : array where each element is height of a bar.

find how much water can fit in between the bar


1 2 3 4

we have to chose two bar and we can use the distance between two bar as length and for the breadth
we can take the min of two bar.

but we do it by keeping the pointer start and end and try to find the limiting bar and move inward
from that side

in the examble we start with 1 7 2 5 4 7 3 6, so we start with 1 and 6 we find area with right -
left * min(left, right) and then move 1 to 7 because it is the limit factor due to which the area is
small


finally return the ans

TC - O(n)
SC - O(1)

*/

class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(heights[left], heights[right]));


            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
