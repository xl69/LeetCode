class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
            cur.prefixCount++;
        }
        cur.wordCount++;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.wordCount;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.prefixCount;
    }
    
    public void erase(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'].prefixCount == 1) {
                cur.children[c - 'a'] = null;
                return;
            }
            cur = cur.children[c - 'a'];
            cur.prefixCount--;
        }
        cur.wordCount--;
    }
}

class TrieNode {
    TrieNode[] children;
    int wordCount, prefixCount;
    public TrieNode() {
        children = new TrieNode[26];
        wordCount = 0;
        prefixCount = 0;
    }
}