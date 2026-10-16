/*
We have to implement trie aka prefix tree.

where we insert one word then if I check that word I should return true if that word is not there
then return false. but if I do starts with and the prefix matches I should return that word

what if there are multiple which matches the prefix?

for direct serach I can use a hashset and check the set when serched

it would be

TC -> O(1)
SC -> O(n)

now if prefix comees in the action

traverse each word and then put it in the hash array as we travesrse the prefix and when prefix ends
we should have also the same hash array since it is only lowercase we have only O(1) as SC and TC
would be n * k k is the longest word length

in new concept we make link nodes

so every node has 26 spaces

as we insert word we traverse through the node and increament that char and if htere is no new node
we create one.

TC insert O(w) search O(w) startswith O(p)
S - O(k) longest word
*/

class PrefixTree {
    private static class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    Node head;

    public PrefixTree() {
        head = new Node();
    }

    public void insert(String word) {
        Node curr = head;
        for (char ch : word.toCharArray()) {
            if( curr.children[ch - 'a'] == null){
                curr.children[ch - 'a']  = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    private Node find(String word, Node curr){
        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null) return curr.children[ch - 'a'];
            curr = curr.children[ch - 'a'];
        }
        return curr;

    }

    public boolean search(String word) {
        Node curr = find(word, head);
        return curr != null && curr.isEnd;

    }

    public boolean startsWith(String prefix) {
        Node curr = find(prefix, head);
        return curr != null;
    }
}
