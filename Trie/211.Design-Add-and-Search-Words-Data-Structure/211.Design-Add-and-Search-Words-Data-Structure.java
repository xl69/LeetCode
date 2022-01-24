class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        insert(word);
    }
    
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        return dfs(cur, word, 0);
    }
    
    private boolean dfs(TrieNode cur, String word, int index) {
        if (cur == null) return false;
        if (index == word.length()) return cur.isWord;
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++)
                if (dfs(cur.children[i], word, index + 1)) return true;
            return false;
        }
        return dfs(cur.children[c - 'a'], word, index + 1);
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
    }
}