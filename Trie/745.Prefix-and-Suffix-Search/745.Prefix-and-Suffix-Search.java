class WordFilter {
    TrieNode root = new TrieNode();
    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder suffix = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                suffix.append(word.charAt(j));
                StringBuilder sb = new StringBuilder();
                sb.append(new StringBuilder(suffix).reverse()).append('{').append(word);
                insert(sb.toString(), i);
            }
        }
    }
    
    private void insert(String word, int index) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.index = Math.max(node.index, index);
        }
    }
    
    public int f(String prefix, String suffix) {
        StringBuilder sb = new StringBuilder();
        sb.append(suffix).append('{').append(prefix);
        TrieNode node = root;
        for (char c : sb.toString().toCharArray()) {
            if (node.children[c - 'a'] == null) return -1;
            node = node.children[c - 'a'];
        }
        return node.index;
    }
}

class TrieNode {
    TrieNode[] children;
    int index;
    public TrieNode() {
        children = new TrieNode[27];
        index = 0;
    }
}