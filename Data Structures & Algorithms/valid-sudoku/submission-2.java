/*

    I can do it with the has set, I need to make the key in such a way that it exatcly says in which
rows is in it and which rows is it in and in which box is it in.




in one set

put all for row and col and box

row#rowNo#value
col#colNo#value
box#boxNo#value

00 22 - 1

row / 3+ col / 3 = 0 + 0 = 0

2/3 + 2/3 = 0

3 / 3 + 3  = 1

03 35 - 2


*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.')
                    continue;

                if(!seen.add("row"
                    + "#" + i + "#" + board[i][j])) return false;
                if(!seen.add("col"
                    + "#" + j + "#" + board[i][j])) return false;
                if(!seen.add("box"
                    + "#" + (i / 3) * 3 + (j / 3) + "#" + board[i][j])) return false;
            }
        }

        return true;
    }
}
