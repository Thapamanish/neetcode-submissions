/*
We have to find the number of islands

islands are those which are not connected

if whole grid is connected somehow and can be reach from one of the point there is only 1 islang

in short we have to find the total number of disconnected grpah

we can do that by traversing through dfs

we start traversing the grid and we find place where value is 1 then we run dfs in 4 directions recursivley up down right and left and then as we visit we make the value to 0 so we don't visit it again, at the beginnig of dfs we increase the count

so after that we return the count;

TC -> O(m * n)
SC - O(h)

*/

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '0') continue;
                islands++;
                dfs(grid, i, j);
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        grid[i][j] = '0';
        for(int[] dir: dirs){
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
