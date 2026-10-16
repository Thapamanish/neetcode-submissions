/*

we need to find the rec with largest area

rectangle could be made with one bar or multiple bar

so we har good until and unelss the bar is increasing but as soon as it starts decreasing it means
we cna't no more continue the same area so we need to calculate the area for the those bar before
proceeding

for e.g

7 1 7 2 2 4

as soon as 1 comes we can't proceed with width 7 so calculate the area till 7 the put 1 7 and when 2
comes 7 can't proceed have same area so find area of 7 then no need to find for 1 because 1 < 2 and
area of rectange consisting 1 can be increased

For this monotonic behaviour we can use stack

TC -> O(n)
SC -> O(n)


*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int prevBar = stack.pop();
                int length = stack.isEmpty() ? i : i - (stack.peek() + 1);
                int width = heights[prevBar];
                area = Math.max(area, length * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int prevBar = stack.pop();
            int length = stack.isEmpty() ? heights.length : heights.length - (stack.peek() + 1);
            int width = heights[prevBar];

            area = Math.max(area, length * width);
        }

        return area;
    }
}


