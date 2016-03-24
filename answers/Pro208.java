class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
    
    public TrieNode() {
        this.isWord = false;
        for (int i = 0 ; i < 26 ; i ++){
            children[i] = null;
        }
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word.length() == 0){
            return;
        }
        TrieNode cur = this.root;
        
        for (int wordIdx = 0 ; wordIdx < word.length() ; wordIdx ++){
            int childrenIdx = word.charAt(wordIdx) - 'a';
            if (cur.children[childrenIdx] == null){
                cur.children[childrenIdx] = new TrieNode();
            }
            
            cur = cur.children[childrenIdx];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word.length() == 0){
            return false;
        }
        TrieNode cur = this.root;
        
        for (int wordIdx = 0 ; wordIdx < word.length() ; wordIdx ++){
            int childrenIdx = word.charAt(wordIdx) - 'a';
            if (cur.children[childrenIdx] == null){
                return false;
            }
            cur = cur.children[childrenIdx];
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0){
            return false;
        }
        TrieNode cur = this.root;
        for (int prefixIdx = 0 ; prefixIdx < prefix.length() ; prefixIdx ++){
            int childrenIdx = prefix.charAt(prefixIdx) - 'a';
            if (cur.children[childrenIdx] == null){
                return false;
            }
            cur = cur.children[childrenIdx];
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");