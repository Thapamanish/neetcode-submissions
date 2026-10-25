/*
so water will help to make go from one cell to another

so we can't go to another cell until they are of same elevation

so we have to reach the end in min amount of time

so from cell 0 to 1 I have to wait from t = 1

to go to 2 I need to wait for 2 basically curr - next

we can do it easily by keeping an extra 2d array which keeps the min val of each

or may be when reached I can store it in ans variable;

I got it but is it TLE

O(2 ^ n) because we have two choices
[[0, 1, 2, 10],
[9, 14, 4, 13],
[12, 14, 8, 15],
[12, 12, 8, 15]]


*/
class Solution {
    public int swimInWater(int[][] grid) {
        int[][] minTime = new int[grid.length][grid[0].length];
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < minTime.length; i++) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        minTime[0][0] = grid[0][0];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        minHeap.offer(new int[] {grid[0][0], 0, 0});
        int[][] directions = new int[][] {{1, 0},{-1, 0}, {0, 1}, {0, -1}};

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            int time = current[0];
            int row = current[1];
            int col = current[2];

            if (time != minTime[row][col])
                continue;
            if (row == rows - 1 && col == cols - 1)
                return time;

            for (int[] dir : directions) {
                int nextRow = dir[0] + row;
                int nextCol = dir[1] + col;

                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols)
                    continue;

                int arrivalTime = Math.max(time, grid[nextRow][nextCol]);
                if (arrivalTime < minTime[nextRow][nextCol]) {
                    minTime[nextRow][nextCol] = arrivalTime;
                    minHeap.offer(new int[] {arrivalTime, nextRow, nextCol});
                }
            }
        }

        return -1;
    }
}
