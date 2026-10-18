/*

The matrix is sorted so if we are able to convert the martrix to a straight single array we can do
binary search

so we will convert the opposite

find mid between 0 to m * n - 1

then for mid we

row = mid / cols
col = mid % cols

TC - O(logn)
SC - O(1)

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
