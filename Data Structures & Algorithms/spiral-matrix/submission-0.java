/*
we have to print the matrix spirally

things to remember here is we need to print
l - r
t - b
r - l
b - t

so there would be 4 variables tracking

and we need to mke sure we don't print twice

for e.g

1  2  3  4
5  6  7  8
9 10 11 12

weh print
1 2 3

then while printing top - bottom we don't print 3 agin

we start with 6

so

l - r -> t++
t - b -> r--
r - l -> b--
b - t -> l++


TC - O(m * n)
SC - O(1)



*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        // we use conditons to come out of the loop

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
