class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, count, grid);
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, int count, char[][] grid){

        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)  return;
        if(grid[row][col] == '0') return;


        grid[row][col] = '0';

        dfs(row + 1, col, count, grid);
        dfs(row - 1, col, count, grid);
        dfs(row, col + 1, count, grid);
        dfs(row, col - 1, count, grid);
    }
}
