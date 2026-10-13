/*
array of integer

each element is height of bar

we have to find largest rectangle

rectangle is length * breadth

so we nee dot find largest length * breadh

and for rectangle everything should be filled being a single long bar is not enough
we can also take part of the bar

ans =
1 * 7 = 7
2 * 1 = 2
3 * 1 = 3
4 * 1 = 4
5 * 1 = 5
6 * 1 = 6


5 * 1 = 5
6 * 2

but how to track mnimum I know the minmum was 1

use stack to track min?

but how?

what if I calculate area till here way

at 7 area till here 7
at 1 area is 2
at 2 area is 3

when to shrink?

7
1

min = 7
ans = 7 * 1


1
2
2
4

*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int prevHeight = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, heights[prevHeight] * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int prevHeight = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            area = Math.max(area, heights[prevHeight] * width);
        }

        return area;
    }
}
