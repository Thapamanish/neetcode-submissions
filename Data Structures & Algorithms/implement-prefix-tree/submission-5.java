/*
Trie{
    Node[] seen;
    boolean isWord;

}

*/

class PrefixTree {
    class Trie {
        Trie[] seen = new Trie[26];
        boolean isWord = false;


    }
    Trie head;
    public PrefixTree() {
        head = new Trie();
    }


    public void insert(String word) {
        Trie curr = head;

        for (int ch : word.toCharArray()) {
            if (curr.seen[ch - 'a'] == null) {
                curr.seen[ch - 'a'] = new Trie();
            }
            curr = curr.seen[ch - 'a'];
        }
        curr.isWord = true;
    }

    private Trie find(String word) {
        Trie curr = head;
        for (int ch : word.toCharArray()) {
            if (curr.seen[ch - 'a'] == null)
                return null;
            curr = curr.seen[ch - 'a'];
        }

        return curr;
    }

    public boolean search(String word) {
        Trie node = find(word);

        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }
}
