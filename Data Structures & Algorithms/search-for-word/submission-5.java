// [["A","B","C","E"],
// ["S","F","C","S"],
// ["A","D","E","E"]]

class Solution {
    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, sb, i, j, 0, visited))
                    return true;
                System.out.println(sb.toString());
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, StringBuilder sb, int i, int j, int start,
        boolean[][] visited) {
        if (word.length() == sb.length() && word.equals(sb.toString()))
            return true;
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || start >= word.length()
            || word.charAt(start) != board[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        sb.append(board[i][j]);
        boolean found = dfs(board, word, sb, i + 1, j, start + 1, visited)
            || dfs(board, word, sb, i - 1, j, start + 1, visited)
            || dfs(board, word, sb, i, j + 1, start + 1, visited)
            || dfs(board, word, sb, i, j - 1, start + 1, visited);

        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);

        return found;
    }
}
