/*
we need to store word and when searched return there is word or not

so if there is word for piceces of the word then for bay .ay or ..y then return true a

can we use trie?


as soon as we find a . then there is possiblity that we could find the next char and also we could
not ifnd as well

[a, b, c, d, -------- .]

N, N, N, N

every layer contains their own path, how to make sure that if we have . we go to the right path to
check?

dots can be in front and back? or it can be at middle as well?



*/

class WordDictionary {
    private class Trie {
        Trie[] seen;
        boolean isWord;

        Trie() {
            seen = new Trie[26];
            isWord = false;
        }
    }

    Trie head;
    public WordDictionary() {
        head = new Trie();
    }

    public void addWord(String word) {
        Trie curr = head;
        for (char ch : word.toCharArray()) {
            if (curr.seen[ch - 'a'] == null) {
                curr.seen[ch - 'a'] = new Trie();
            }
            curr = curr.seen[ch - 'a'];
        }

        curr.isWord = true;
    }

    private boolean checkTrue(int left, int right, Trie curr, String word) {
        while (left <= right) {
            char ch = word.charAt(left);
            if (ch == '.') {
                for (int i = 0; i < 26; i++) {
                    if (curr.seen[i] != null) {
                        boolean found = checkTrue(left + 1, right, curr.seen[i], word);
                        if (found)
                            return true;
                    }
                }

                return false;
            } else {
                if (curr.seen[ch - 'a'] == null)
                    return false;
                left++;
                curr = curr.seen[ch - 'a'];
            }
        }

        return curr.isWord == true;
    }

    public boolean search(String word) {
        return checkTrue(0, word.length() - 1, head, word);
    }
}
