package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q211_Add_and_Search_Word_Data_structure_design {
    private TrieNode root = new TrieNode();

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            TrieNode node = curr.children.get(c);
            if (node == null) {
                node = new TrieNode();
                curr.children.put(c, node);
            }
            curr = node;
        }
        curr.isLeaf = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return dfsSearch(root.children, word, 0);
    }

    public boolean dfsSearch(Map<Character, TrieNode> children, String word, int start) {
        if (start == word.length()) {
            if (children.size() == 0)
                return true;
            else
                return false;
        }

        char c = word.charAt(start);

        if (children.containsKey(c)) {
            if (start == word.length() - 1 && children.get(c).isLeaf) {
                return true;
            }

            return dfsSearch(children.get(c).children, word, start + 1);
        } else if (c == '.') {
            boolean result = false;
            for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
                if (start == word.length() - 1 && child.getValue().isLeaf) {
                    return true;
                }

                //if any path is true, set result to be true;
                if (dfsSearch(child.getValue().children, word, start + 1)) {
                    result = true;
                }
            }

            return result;
        } else {
            return false;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isLeaf;

        public TrieNode() {
            this.isLeaf = false;
            this.children = new HashMap<Character, TrieNode>();
        }
    }
}
