import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean leaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode(char c) {
        this.c = c;
    }

    public TrieNode(){};
}

 class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if(i==word.length()-1) t.leaf=true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t!=null && t.leaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!children.containsKey(c)) return null;
            t = children.get(c);
            children = t.children;
        }
        return t;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

public class Leetcode208 {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("apple");
        boolean res=trie.search("appla");
        System.out.println(res);

    }
}
