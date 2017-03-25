package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q211_Add_and_Search_Word_Data_structure_design {
    private TrieNode root = new TrieNode();
    private TrieNode dummyRoot = root;

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        int offset = 'a';
        int i = 0;
        for (i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (curr.children[character - offset] == null) {
                curr.children[character - offset] =
                        new TrieNode(character, i == word.length() - 1 ? true : false);
            } else {
                if (i == word.length() - 1) {
                    curr.children[character - offset].leaf = true;
                }
            }

            curr = curr.children[character - offset];
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        TrieNode curr = root;
        int offset = 'a';
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character != '.') {
                if (curr.children[character - offset] == null) {
                    return false;
                }
                curr = curr.children[character - offset];
            } else {
                // DFS
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null) {
                        if (i == word.length() - 1 && curr.children[j].leaf) {
                            root = dummyRoot;
                            return true;
                        }

                        root = curr.children[j];
                        if (search(word.substring(i + 1))) {
                            root = dummyRoot;
                            return true;
                        }
                    }
                }
                root = dummyRoot;
                return false;
            }
        }

        if (curr != null && curr.leaf == false) {
            return false;
        }

        return true;
    }

    class TrieNode {
        char val;
        boolean leaf;
        TrieNode[] children;

        public TrieNode() {
            this.val = '\0';
            this.leaf = false;
            this.children = new TrieNode[26];
        }

        public TrieNode(char val, boolean leaf) {
            this.val = val;
            this.leaf = leaf;
            this.children = new TrieNode[26];
        }
    }
}
