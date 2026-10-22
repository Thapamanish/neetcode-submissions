/*
find area

find the islands

find the disconnected graphs

find area of the graphs and find the max area among them

use dfs to do it.

TC = O(m * n)
SC = O(h)
*/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0)
                    continue;
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1)
            + dfs(grid, i, j - 1);
    }
}
