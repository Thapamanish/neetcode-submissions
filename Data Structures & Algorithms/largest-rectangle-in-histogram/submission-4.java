/*
we need to find the largest possible rectangle

we will be having multiple small and big rectangle

rectangle breadth is limited by the smaller bar

so as soon as we get smaller bar we need to calculate the area till prev bar than curr

and at last as well once we have completed the traversal we need to calculate the area of the area
consising till bar present

e.g

7 1 7 2 2 4

7
7 1 -> calculate till 7 and pop 7
1
1 7
1 7 2 -> calculate till 7 from prev smallest
1 2
1 2 2 -> calculate till 2 nd pop
1 2
1 2 4 -> traversal complete

assume we have 0 then do the same for remaining


TC -O(n)
SC - O(n) stack

*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int best = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int breadth = heights[stack.pop()];
                int length = stack.isEmpty() ? i : i - stack.peek() - 1;

                best = Math.max(best, length * breadth);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int breadth = heights[stack.pop()];

            int length = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;

            best = Math.max(best, length * breadth);
        }

        return best;
    }
}
