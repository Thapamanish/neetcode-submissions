/*
I can use dfs to do it

start from the first element keep a visited array to make sure I don't calculate for it again,

maintain a best answer if found nay replace


*/

class Solution {
    int best = 1;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) dfs(matrix, visited, i, j, Integer.MIN_VALUE);

        return best;
    }

    public int dfs(int[][] matrix, int[][] visited, int i, int j, int last) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= last)
            return 0;

        if (visited[i][j] != 0)
            return visited[i][j];
        int down = dfs(matrix, visited, i + 1, j, matrix[i][j]);
        int up = dfs(matrix, visited, i - 1, j, matrix[i][j]);
        int left = dfs(matrix, visited, i, j - 1, matrix[i][j]);
        int right = dfs(matrix, visited, i, j + 1, matrix[i][j]);

        visited[i][j] = 1 + Math.max(down, Math.max(up, Math.max(left, right)));
        best = Math.max(best, visited[i][j]);
        return visited[i][j];
    }
}
