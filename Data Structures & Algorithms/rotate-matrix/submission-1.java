/*

reverse rows and transpose

*/

class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // reverse
        int top = 0, bottom = rows - 1;

        while (top < bottom) {
            int[] temp = matrix[top];
            matrix[top++] = matrix[bottom];
            matrix[bottom--] = temp;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
