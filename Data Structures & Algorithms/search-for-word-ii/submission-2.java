/*
We can use dfs plus back tracking to do it


O(m * n * 3^L)

but I can find all possible word store it in Trie and find from it?




*/

class Solution {
    class TrieNode {
        TrieNode[] node = new TrieNode[26];
        boolean isWord = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> matched = new ArrayList<>();
        TrieNode head = new TrieNode();

        for (String word : words) {
            addToTrie(word, head);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder sb = new StringBuilder();
                dfs(board, i, j, sb, matched, head);
            }
        }

        return matched;
    }

    private void addToTrie(String word, TrieNode head) {
        for (char ch : word.toCharArray()) {
            int curr = ch - 'a';
            if (head.node[curr] == null)
                head.node[curr] = new TrieNode();

            head = head.node[curr];
        }
        head.isWord = true;
    }

    private void dfs(
        char[][] board, int i, int j, StringBuilder sb, List<String> matched, TrieNode head) {
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] == '\0') {
            return;
        }
        int curr = board[i][j] - 'a';

        if (head.node[curr] == null)
            return;
        char original = board[i][j];
        board[i][j] = '\0';
        sb.append(original);
        if (head.node[curr].isWord){
            matched.add(sb.toString());
            head.node[curr].isWord = false;
        }

        dfs(board, i + 1, j, sb, matched, head.node[curr]);
        dfs(board, i - 1, j, sb, matched, head.node[curr]);
        dfs(board, i, j + 1, sb, matched, head.node[curr]);
        dfs(board, i, j - 1, sb, matched, head.node[curr]);

        board[i][j] = original;
        sb.deleteCharAt(sb.length() - 1);
    }
}
