/*

One pattern I am able to see is rows become cols or in other way col from end becomes row from first
need to do inplace

I think we need to do in two steps if we want to do inplace 

first reverse the order and then transpose it

O(m/ 2) + O() 

7 8 9
4 5 6
1 2 3

*/

class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows - 1;

        // reverse
        while(left < right){
            int[] temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }

        // transpose

        for(int i = 0; i< rows; i++){
            for(int j = i + 1; j < cols; j++){
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        
    }
}
