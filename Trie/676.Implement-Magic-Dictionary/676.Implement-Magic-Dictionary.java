class MagicDictionary {
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            insert(word);
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(searchWord, 0, root);
    }
    
    private boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return true;
        }
        char cur = word.charAt(index);
        for (char c = 'a'; c <= 'z'; c++) {
            if (c == cur) {
                if (index != word.length() - 1 &&
                    node.children[c - 'a'] != null && 
                    dfs(word, index + 1, node.children[c - 'a'])) {
                    return true;
                }
            } else {
                if (node.children[c - 'a'] != null && 
                    searchFromIndex(word, index + 1, node.children[c - 'a'])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean searchFromIndex(String word, int index, TrieNode node) {
        for (int i = index; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) return false;
            node = node.children[word.charAt(i) - 'a'];
        }
        return node.isWord;
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
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
    }
}