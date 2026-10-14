/*
we are given array of integer where each integer is height of the bar.

so water can be hold up to the point where one of the bar ends, which means water is limited by the
smaller side

so I will use two pointer technique and traverse and meanwhile find the area and store the max as I
go ahead


I will shrink the window form the side where there is limiting bar , which means the smaller bar.

e.g

1 7 2 5 4 7 3 6

1 6  -> min(1, 6) * (right - left)
7 6 -> min(7, 6) * (right - left)
7 3 -> min(7, 3)


return ans


TC - O(n)
SC - O(1)


*/
class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int ans = 0;

        while (left < right) {
            ans = Math.max(ans, Math.min(heights[left], heights[right]) * (right - left));
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return ans;
    }
}
