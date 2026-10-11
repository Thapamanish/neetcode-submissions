class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        int n = heights.length;

        int maxSoFar = 0;

        for(int i = 0; i <= n; i++){

            int currentHeight = (i == n) ? 0: heights[i];
                while(!stack.isEmpty() && heights[stack.peek()] > currentHeight){
         
                    int currHeight = heights[stack.pop()];
                    int currWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxSoFar = Math.max(maxSoFar, currHeight * currWidth);

                }
            stack.push(i);
            
        }

        return maxSoFar;
    }
}
