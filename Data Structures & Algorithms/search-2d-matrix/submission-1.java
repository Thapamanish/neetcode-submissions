/*
input: array of array

goal: to find target element

given: each row is in asc order and prev row last ele < new row first ele


brute force approach would be to linearly search the element


TC - O(n)


can we decrease the tc?

given : sorted row, why?

can we use binary search

if yes, bend the matrix to straight line


row 3

col 4

1 2 3 4 [0 ]
10 11 12 13 [1 ]
14 20 30 40 [2 ]

0 - 11

4th element -> 1, 0 [4/row, 4%col]

so left = 0, right = (row * col) - 1

find mid and convert to matrix index, check the ele if yes return true else if mid < target ,  left = mid + 1 else right = mid - 1

return false at the end;

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int value = matrix[mid / cols][mid % cols];
            if(value == target) return true;
            else if(value < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
