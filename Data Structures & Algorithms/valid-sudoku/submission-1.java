/*
given a sudoko

check if it is valid or not

1. check if every row has non duplicate lelement
2. every col has non duplicate element
3. each 3*3 has non duplicate element -> row = n / 3 col = n % 3


do it three times and use hash set to check if that element is in that or not if yes return false
else continue to next step


TC -> O(9 * 9)
SC -> O(9)


*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int m = 0; m < 9; m++) {
            Set<Character> seen = new HashSet<>();
            for (int n = 0; n < 9; n++) {
                if (board[m][n] == '.')
                    continue;
                if (!seen.add(board[m][n]))
                    return false;
            }
        }

        for (int n = 0; n < 9; n++) {
            Set<Character> seen = new HashSet<>();
            for (int m = 0; m < 9; m++) {
                if (board[m][n] == '.')
                    continue;
                if (!seen.add(board[m][n]))
                    return false;
            }
        }

        for (int m = 0; m < 9; m += 3) {
            for (int n = 0; n < 9; n += 3) {
                Set<Character> seen = new HashSet<>();
                for (int i = m; i < m + 3; i++) {
                    for (int j = n; j < n + 3; j++) {
                        if (board[i][j] == '.')
                            continue;
                        if (!seen.add(board[i][j]))
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
