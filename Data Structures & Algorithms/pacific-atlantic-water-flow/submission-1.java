/*
we have to find while doing dfs we can reach to both pacific and atlanatic

pacfic is i = 0 and j = 0

atlantic is i = rows.length and j = cols.length

we have to traverse from i ==0 j = 1 to col

and i = 1 - row and j = 0

then see if we reach other

if i != 0 || i != rows.length - 1 || j != 0 || j != cols.length -1 then skip





*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // pacific
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dfs(heights, i, j, pacific, heights[i][j]);
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 || j == cols - 1) {
                    dfs(heights, i, j, atlantic, heights[i][j]);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited, int last) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j]
            || heights[i][j] < last)
            return;

        visited[i][j] = true;
        dfs(heights, i + 1, j, visited, heights[i][j]);
        dfs(heights, i - 1, j, visited, heights[i][j]);
        dfs(heights, i, j + 1, visited, heights[i][j]);
        dfs(heights, i, j - 1, visited, heights[i][j]);
    }
}
