/*
the goal of the problem is to find if the element is there in the matrix or not

if not return false if yes return true;

we can use liner search but it would be O(n)

but if we have sorted rows and rows itself are in ascending order

we can use binary search

but we need to convert 2d to 1d so that we can use logic of binary serach

if we look clearly our cols = 4 in the example since it is zero based indexing it is from 0 1 2 3

and for the fourth element it is again 0 which means n / 4 gives us col index

for rows we have 3 and if for fisrt 4 element the row is 0 which emans till 4 which is no of col row
should be zero which could be got by % so row index is n % 4

I got it oppsige for rows it should be divide and for col it should be %


*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int n = rows * cols;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
                     System.out.println(mid + "------");
            int curr = matrix[mid / cols][mid % cols];

            System.out.println(curr);
            if (curr == target)
                return true;
            else if (curr < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
