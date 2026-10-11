class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int low = 0;
        int high = n - 1;

        int maxArea = 0;
        while(low < high){
            int area = Math.min(heights[low], heights[high]) * (high - low);

            maxArea = Math.max(area, maxArea);

            if(heights[low] < heights[high]) low++;
            else high--;
        }

        return maxArea;
    }
}
