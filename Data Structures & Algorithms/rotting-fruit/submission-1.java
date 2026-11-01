/*

we can use bfs, levl order travesal

at each level it is one minute

if there is any new level th emniute increases


at the end we do one more traversal to see if there is any fresh fruit if yes return - 1 else return
the min mins

TC - O(m * N)
SC - O(k) k is rotten

but there could be multiple start point so we store all the rotten orange ther could be in the queue
and process it

*/

class Solution {
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[] {i, j});
            }
        }

        int time = -1;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] curr = q.poll();

                for (int[] dir : dirs) {
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];

                    if (i < 0 || j < 0 || j >= cols || i >= rows || grid[i][j] != 1)
                        continue;
                    grid[i][j] = 2;

                    q.offer(new int[] {i, j});
                }
                size--;
            }

            time++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return time == - 1 ? 0 : time;
    }
}
