/*

if matrix[i][j] == 0

then matrix[i][1-n] and matrix[1-m][n] is zero

the issue is if we replace the row and col with 0 we could miss which pos was actually zero

we could replace with other value like
 instead of replacing w repalce with * for e.g only for non zero and fafter completeion again
replace * with 0


 but we only need to use int

 1 1
 0 0
 1 1

what if I put zero in the top of rows and cols and at then end traverse and make it all zero?

0 0 0 1
1 0 1 1
1 0 1 1



what if there is zero in the corner?
check with two var if there are any zero in the first row then everything in first row will be zero

same goes in the first col


other wise it won't


*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int j = 0; j < rows; j++) {
            if (matrix[j][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if ((matrix[i][0] == 0) || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
