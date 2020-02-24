package main.search;

/**
 * @author wenzhuang
 * @date 2020/2/23 4:10 PM
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}
